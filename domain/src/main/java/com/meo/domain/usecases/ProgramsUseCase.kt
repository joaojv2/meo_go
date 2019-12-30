package com.meo.domain.usecases

import com.meo.domain.aggregate.ProgramCatalog
import com.meo.domain.entities.response.RemoteResponse

interface ProgramsUseCase {

    suspend fun getProgramCatalog(channelCallLetter: String): RemoteResponse<ProgramCatalog>
}