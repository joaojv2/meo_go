package com.meo.data.mappers

import com.meo.data.mappers.base.BaseMapper
import com.meo.data.models.ProgramCatalogResponseBody
import com.meo.data.models.ProgramResponseBody
import com.meo.domain.aggregate.ProgramCatalog
import com.meo.domain.entities.Program

class ProgramCatalogResponseToProgramCatalog(
    private val programResponseToProgram: BaseMapper<ProgramResponseBody, Program>
) : BaseMapper<ProgramCatalogResponseBody, ProgramCatalog> {

    override fun map(input: ProgramCatalogResponseBody): ProgramCatalog {
        return ProgramCatalog(
            input.programs?.map { programResponseToProgram.map(it) }
        )
    }
}