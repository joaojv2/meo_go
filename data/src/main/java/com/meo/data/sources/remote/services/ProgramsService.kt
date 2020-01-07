package com.meo.data.sources.remote.services

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ProgramsService {

    @GET("")
    fun getPrograms(
        @Url url: String
    ): Deferred<Response<ResponseBody>>
}