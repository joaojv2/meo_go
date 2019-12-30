package com.meo.data.models

import com.google.gson.annotations.SerializedName

data class ProgramResponseBody(
    @SerializedName(ID) val id: Long?,
    @SerializedName(TITLE) val title: String?
) {

    private companion object {
        private const val ID: String = "Id"
        private const val TITLE: String = "Title"
    }
}