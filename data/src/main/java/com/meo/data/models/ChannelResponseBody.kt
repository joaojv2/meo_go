package com.meo.data.models

import com.google.gson.annotations.SerializedName

data class ChannelResponseBody(
    @SerializedName(ID) val id: Long?,
    @SerializedName(TITLE) val title: String?,
    @SerializedName(CALL_LETTER) val callLetter: String?
) {

    private companion object {
        private const val ID: String = "Id"
        private const val TITLE: String = "Title"
        private const val CALL_LETTER: String = "CallLetter"
    }
}