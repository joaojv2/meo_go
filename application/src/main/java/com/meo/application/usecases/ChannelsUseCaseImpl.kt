package com.meo.application.usecases

import com.meo.domain.aggregate.ChannelCatalog
import com.meo.domain.entities.response.RemoteResponse
import com.meo.domain.repositories.ChannelsRepository
import com.meo.domain.usecases.ChannelsUseCase

class ChannelsUseCaseImpl(
    private val channelsRepository: ChannelsRepository
) : ChannelsUseCase {

    override suspend fun getChannelCatalog(url: String?): RemoteResponse<ChannelCatalog> {
        return channelsRepository.getChannelCatalog(url)
    }
}