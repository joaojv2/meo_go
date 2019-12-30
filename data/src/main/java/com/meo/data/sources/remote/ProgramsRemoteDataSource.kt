package com.meo.data.sources.remote

import com.meo.domain.aggregate.ProgramCatalog
import com.meo.domain.entities.response.RemoteResponse

interface ProgramsRemoteDataSource {

    suspend fun getProgramCatalog(channelCallLetter: String): RemoteResponse<ProgramCatalog>
}