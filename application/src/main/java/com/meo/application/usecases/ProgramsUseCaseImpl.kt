package com.meo.application.usecases

import com.meo.domain.aggregate.ProgramCatalog
import com.meo.domain.entities.response.RemoteResponse
import com.meo.domain.repositories.ProgramsRepository
import com.meo.domain.usecases.ProgramsUseCase

class ProgramsUseCaseImpl(
    private val programsRepository: ProgramsRepository
) : ProgramsUseCase {

    override suspend fun getProgramCatalog(channelCallLetter: String): RemoteResponse<ProgramCatalog> {
        return programsRepository.getProgramCatalog(channelCallLetter)
    }
}