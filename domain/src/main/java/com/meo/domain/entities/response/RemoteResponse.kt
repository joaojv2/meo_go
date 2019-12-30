package com.meo.domain.entities.response

sealed class RemoteResponse<T> {

    data class Success<T>(val body: T) : RemoteResponse<T>()

    data class Error<T>(val message: String?) : RemoteResponse<T>()
}