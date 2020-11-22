package com.laam.core.ext.repository

import com.laam.core.ext.idling.EspressoIdlingResource
import kotlinx.coroutines.flow.flow
import retrofit2.Response

abstract class NetworkBoundRepository<DB, REMOTE> {

    fun asFlow() = flow<State<DB>> {
        EspressoIdlingResource.increment()

        emit(State.loading())

        val localData = fetchFromLocal()

        try {
            val apiResponse = fetchFromRemote()
            val remoteData = apiResponse.body()

            if (apiResponse.isSuccessful && remoteData != null) {
                if (shouldSaveToLocal(remoteData)) {
                    saveRemoteData(remoteData)
                }

                emit(State.success(mapFromRemote(remoteData)))
            } else {
                emit(State.error(apiResponse.message(), localData))
            }

            EspressoIdlingResource.decrement()
        } catch (ex: Exception) {
            emit(State.error("Cannot fetch from remote, network error.", localData))
            ex.printStackTrace()
        }
    }

    protected abstract suspend fun fetchFromRemote(): Response<REMOTE>

    protected abstract fun fetchFromLocal(): DB

    protected abstract fun saveRemoteData(data: REMOTE)

    protected abstract fun shouldSaveToLocal(data: REMOTE?): Boolean

    protected abstract fun mapFromRemote(data: REMOTE): DB
}