package com.meo.data.repositories

import com.meo.data.sources.remote.ProgramsRemoteDataSource
import com.meo.domain.aggregate.ProgramCatalog
import com.meo.domain.entities.response.RemoteResponse
import com.meo.domain.repositories.ProgramsRepository

class ProgramsRepositoryImpl(
    private val programsRemoteDataSource: ProgramsRemoteDataSource
) : ProgramsRepository {

    override suspend fun getProgramCatalog(channelCallLetter: String): RemoteResponse<ProgramCatalog> {
        return programsRemoteDataSource.getProgramCatalog(channelCallLetter)
    }
}