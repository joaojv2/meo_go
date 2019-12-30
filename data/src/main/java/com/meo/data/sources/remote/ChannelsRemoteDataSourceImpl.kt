package com.meo.data.sources.remote

import com.meo.data.extensions.mapToResponseEntity
import com.meo.data.mappers.base.BaseMapper
import com.meo.data.models.ChannelCatalogResponseBody
import com.meo.data.sources.remote.services.ChannelsService
import com.meo.domain.aggregate.ChannelCatalog
import com.meo.domain.entities.response.RemoteResponse

class ChannelsRemoteDataSourceImpl(
    private val channelService: ChannelsService,
    private val mapperToChannelCatalog: BaseMapper<ChannelCatalogResponseBody, ChannelCatalog>
) : ChannelsRemoteDataSource {

    override suspend fun getChannelCatalog(): RemoteResponse<ChannelCatalog> {
        return channelService.getChannels().await()
            .mapToResponseEntity(mapperToChannelCatalog)
    }
}