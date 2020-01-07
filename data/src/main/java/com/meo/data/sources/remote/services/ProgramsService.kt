package com.meo.data.sources.remote.services

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProgramsService {

    @GET("https://ott.online.meo.pt/Program/v7/Programs/NowAndNextLiveChannelPrograms?UserAgent=AND&\$filter=CallLetter%20eq%20%27GLOB%27&\$orderby=StartDate%20asc")
    fun getPrograms(
        @Query("filter") channelCallLetter: String
    ): Deferred<Response<ResponseBody>>
}