package com.meo.data.models

import com.google.gson.annotations.SerializedName

data class ProgramCatalogResponseBody(
    @SerializedName(PROGRAMS) val programs: List<ProgramResponseBody>?
) {

    private companion object {
        private const val PROGRAMS: String = "value"
    }
}