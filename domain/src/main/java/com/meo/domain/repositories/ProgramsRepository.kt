package com.meo.domain.repositories

import com.meo.domain.aggregate.ProgramCatalog
import com.meo.domain.entities.response.RemoteResponse

interface ProgramsRepository {

    suspend fun getProgramCatalog(channelCallLetter: String): RemoteResponse<ProgramCatalog>
}