package com.meo.data.sources.remote.services

import com.meo.data.models.ProgramCatalogResponseBody
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProgramsService {

    @GET("Program/v7/Programs/NowAndNextLiveChannelPrograms?UserAgent=AND&\$filter=CallLetter%20eq%20%27{channel_call_letter}%27&\$orderby=StartDate%20asc")
    fun getPrograms(
        @Path("channel_call_letter") channelCallLetter: String
    ): Deferred<Response<ProgramCatalogResponseBody>>
}