package com.meo.data.repositories

import com.meo.data.sources.remote.ChannelsRemoteDataSource
import com.meo.domain.aggregate.ChannelCatalog
import com.meo.domain.entities.response.RemoteResponse
import com.meo.domain.repositories.ChannelsRepository

class ChannelsRepositoryImpl(
    private val channelsRemoteDataSource: ChannelsRemoteDataSource
) : ChannelsRepository {

    override suspend fun getChannelCatalog(): RemoteResponse<ChannelCatalog> {
        return channelsRemoteDataSource.getChannelCatalog()
    }
}