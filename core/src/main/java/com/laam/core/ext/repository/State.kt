package com.laam.core.ext.repository

sealed class State<T> {
    class Loading<T> : State<T>()

    data class Success<T>(val data: T) : State<T>()

    data class Error<T>(val message: String, val data: T?) : State<T>()

    companion object {

        fun <T> loading() = Loading<T>()

        fun <T> success(data: T) = Success(data)

        fun <T> error(message: String, data: T?) = Error<T>(message, data)
    }
}