package com.laam.core.ext.repository

import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.lang.Exception

abstract class NetworkBoundRepository<REQUEST, RESPONSE> {

    fun asFlow() = flow<State<RESPONSE>> {
        emit(State.loading())

        try {
            val apiResponse = fetchFromRemote()
            val remoteData = apiResponse.body()

            if (apiResponse.isSuccessful && remoteData != null) {
                emit(State.success(mapFromRemote(remoteData)))
            } else {
                emit(State.error(apiResponse.message()))
            }
        } catch (ex: Exception) {
            emit(State.error("Network error!"))
            ex.printStackTrace()
        }
    }

    protected abstract suspend fun fetchFromRemote(): Response<REQUEST>

    protected abstract suspend fun mapFromRemote(request: REQUEST): RESPONSE
}