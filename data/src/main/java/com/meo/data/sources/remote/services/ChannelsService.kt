package com.meo.data.sources.remote.services

import com.meo.data.models.ChannelCatalogResponseBody
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ChannelsService {

    @GET("catalog/v7/Channels?UserAgent=AND&\$filter=substringof(%27MEO_Mobile%27,AvailableOnChannels)%20and%20IsAdult%20eq%20false&\$orderby=ChannelPosition%20asc&\$inlinecount=allpages")
    fun getChannels(): Deferred<Response<ChannelCatalogResponseBody>>
}