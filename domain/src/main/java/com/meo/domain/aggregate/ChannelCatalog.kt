package com.meo.domain.aggregate

import com.meo.domain.entities.Channel

data class ChannelCatalog(
    val count: Long?,
    val nextLink: String?,
    val channels: List<Channel>?
)