package com.meo.data.mappers

import com.meo.data.mappers.base.BaseMapper
import com.meo.data.models.ChannelCatalogResponseBody
import com.meo.data.models.ChannelResponseBody
import com.meo.domain.aggregate.ChannelCatalog
import com.meo.domain.entities.Channel

class ChannelCatalogResponseToChannelCatalog(
    private val channelResponseToChannel: BaseMapper<ChannelResponseBody, Channel>
) : BaseMapper<ChannelCatalogResponseBody, ChannelCatalog> {

    override fun map(input: ChannelCatalogResponseBody): ChannelCatalog {
        return ChannelCatalog(
            input.count,
            input.nextLink,
            input.channels?.map { channelResponseToChannel.map(it) }
        )
    }
}