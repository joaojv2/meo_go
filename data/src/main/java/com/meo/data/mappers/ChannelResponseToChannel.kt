package com.meo.data.mappers

import com.meo.data.mappers.base.BaseMapper
import com.meo.data.models.ChannelResponseBody
import com.meo.domain.entities.Channel

class ChannelResponseToChannel : BaseMapper<ChannelResponseBody, Channel> {

    override fun map(input: ChannelResponseBody): Channel {
        return Channel(
            input.id,
            input.title,
            input.callLetter
        )
    }
}