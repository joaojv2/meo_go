package com.meo.data.extensions

import com.google.gson.Gson
import com.meo.data.mappers.base.BaseMapper
import com.meo.domain.entities.response.RemoteResponse
import okhttp3.ResponseBody
import retrofit2.Response

//fun <T, O> Response<T>.mapToResponseEntity(mapper: BaseMapper<T, O>): RemoteResponse<O> {
//    return when {
//        isSuccessful && code() == 200 -> RemoteResponse.Success(mapper.map(body()!!))
//        else -> RemoteResponse.Error(this.message())
//    }
//}

inline fun <reified T, O> Response<ResponseBody>.mapToResponseEntity(mapper: BaseMapper<T, O>): RemoteResponse<O> {
    return when {
        isSuccessful && code() == 200 -> {
            RemoteResponse.Success(
                mapper.map(
                    Gson().fromJson(
                        String(this.body()?.source()?.readByteArray()!!),
                        T::class.java
                    )
                )
            )
        }
        else -> RemoteResponse.Error(this.message())
    }
}