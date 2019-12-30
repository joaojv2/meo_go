package com.meo.domain.usecases

import com.meo.domain.aggregate.ChannelCatalog
import com.meo.domain.entities.response.RemoteResponse

interface ChannelsUseCase {

    suspend fun getChannelCatalog(url: String?): RemoteResponse<ChannelCatalog>
}