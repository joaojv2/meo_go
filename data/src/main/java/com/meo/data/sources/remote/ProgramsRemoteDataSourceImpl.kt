package com.meo.data.sources.remote

import com.meo.data.extensions.mapToResponseEntity
import com.meo.data.mappers.base.BaseMapper
import com.meo.data.models.ProgramCatalogResponseBody
import com.meo.data.sources.remote.services.ProgramsService
import com.meo.domain.aggregate.ProgramCatalog
import com.meo.domain.entities.response.RemoteResponse

class ProgramsRemoteDataSourceImpl(
    private val programsService: ProgramsService,
    private val mapperToProgramCatalog: BaseMapper<ProgramCatalogResponseBody, ProgramCatalog>
) : ProgramsRemoteDataSource {

    override suspend fun getProgramCatalog(channelCallLetter: String): RemoteResponse<ProgramCatalog> {
        val url = "https://ott.online.meo.pt/Program/v7/Programs/NowAndNextLiveChannelPrograms?UserAgent=AND&\$filter=CallLetter%20eq%20%27${channelCallLetter}%27&\$orderby=StartDate%20asc"

        return programsService.getPrograms(url).await()
            .mapToResponseEntity(mapperToProgramCatalog)
    }
}