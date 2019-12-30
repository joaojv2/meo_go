package com.meo.domain.entities

import com.meo.domain.aggregate.ProgramCatalog

data class Channel(
    val id: Long?,
    val title: String?,
    val callLetter: String?,
    var imageUrl: String? = null,
    var programs: ProgramCatalog? = null
)