package com.meo.domain.aggregate

import com.meo.domain.entities.Program

data class ProgramCatalog(
    val programs: List<Program>?
)