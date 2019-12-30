package com.meo.data.models

import com.google.gson.annotations.SerializedName

data class ChannelCatalogResponseBody(
    @SerializedName(COUNT) val count: Long?,
    @SerializedName(NEXT_LINK) val nextLink: String?,
    @SerializedName(VALUE) val channels: List<ChannelResponseBody>?
) {

    private companion object {
        private const val COUNT: String = "odata.count"
        private const val NEXT_LINK: String = "odata.nextLink"
        private const val VALUE: String = "value"
    }
}