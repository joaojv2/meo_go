package com.meo.data.extensions

import com.meo.data.mappers.base.BaseMapper
import com.meo.domain.entities.response.RemoteResponse
import retrofit2.Response

fun <T, O> Response<T>.mapToResponseEntity(mapper: BaseMapper<T, O>): RemoteResponse<O> {
    return when {
        isSuccessful && code() == 200 -> RemoteResponse.Success(mapper.map(body()!!))
        else -> RemoteResponse.Error(this.message())
    }
}