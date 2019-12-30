package com.meo.data.sources.remote

import com.meo.domain.aggregate.ChannelCatalog
import com.meo.domain.entities.response.RemoteResponse

interface ChannelsRemoteDataSource {

    suspend fun getChannelCatalog(url: String?): RemoteResponse<ChannelCatalog>
}