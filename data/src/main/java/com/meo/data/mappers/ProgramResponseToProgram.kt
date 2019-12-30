package com.meo.data.mappers

import com.meo.data.mappers.base.BaseMapper
import com.meo.data.models.ProgramResponseBody
import com.meo.domain.entities.Program

class ProgramResponseToProgram : BaseMapper<ProgramResponseBody, Program> {

    override fun map(input: ProgramResponseBody): Program {
        return Program(
            input.id,
            input.title
        )
    }
}