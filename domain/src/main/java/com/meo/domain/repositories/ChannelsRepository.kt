package com.meo.domain.repositories

import com.meo.domain.aggregate.ChannelCatalog
import com.meo.domain.entities.response.RemoteResponse

interface ChannelsRepository {

    suspend fun getChannelCatalog(url: String?): RemoteResponse<ChannelCatalog>
}