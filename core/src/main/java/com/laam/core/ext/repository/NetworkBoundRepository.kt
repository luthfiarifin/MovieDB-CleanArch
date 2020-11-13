package com.laam.core.ext.repository

import com.laam.core.ext.idling.EspressoIdlingResource
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.lang.Exception

abstract class NetworkBoundRepository<REQUEST, RESPONSE> {

    fun asFlow() = flow<State<RESPONSE>> {
        EspressoIdlingResource.increment()

        emit(State.loading())

        try {
            val apiResponse = fetchFromRemote()
            val remoteData = apiResponse.body()

            if (apiResponse.isSuccessful && remoteData != null) {
                emit(State.success(mapFromRemote(remoteData)))
            } else {
                emit(State.error(apiResponse.message()))
            }

            EspressoIdlingResource.decrement()
        } catch (ex: Exception) {
            emit(State.error("Network error!"))
            ex.printStackTrace()
        }
    }

    protected abstract suspend fun fetchFromRemote(): Response<REQUEST>

    protected abstract suspend fun mapFromRemote(request: REQUEST): RESPONSE
}