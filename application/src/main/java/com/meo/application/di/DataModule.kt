package com.meo.application.di

import com.meo.application.di.InfrastructureModule.INTERCEPTOR_HELPER
import com.meo.application.di.InfrastructureModule.MOSHI_HELPER
import com.meo.data.mappers.ChannelCatalogResponseToChannelCatalog
import com.meo.data.mappers.ChannelResponseToChannel
import com.meo.data.mappers.ProgramCatalogResponseToProgramCatalog
import com.meo.data.mappers.ProgramResponseToProgram
import com.meo.data.repositories.ChannelsRepositoryImpl
import com.meo.data.repositories.ProgramsRepositoryImpl
import com.meo.data.sources.remote.ChannelsRemoteDataSource
import com.meo.data.sources.remote.ChannelsRemoteDataSourceImpl
import com.meo.data.sources.remote.ProgramsRemoteDataSource
import com.meo.data.sources.remote.ProgramsRemoteDataSourceImpl
import com.meo.data.sources.remote.services.ChannelsService
import com.meo.data.sources.remote.services.ProgramsService
import com.meo.domain.repositories.ChannelsRepository
import com.meo.domain.repositories.ProgramsRepository
import com.meo.infrastructure.builders.RetrofitBuilder
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

object DataModule {

    private const val CHANNEL_RESPONSE_TO_CHANNEL: String = "ChannelResponseToChannel"
    private const val CHANNEL_CATALOG_RESPONSE_TO_CHANNEL_CATALOG: String =
        "ChannelCatalogResponseToChannelCatalog"

    private const val PROGRAM_RESPONSE_TO_PROGRAM: String = "ProgramResponseToProgram"
    private const val PROGRAM_CATALOG_RESPONSE_TO_PROGRAM_CATALOG: String =
        "ProgramCatalogResponseToProgramCatalog"


    val mappers = module { ->

        single(named(CHANNEL_RESPONSE_TO_CHANNEL)) { _ ->
            ChannelResponseToChannel()
        }

        single(named(CHANNEL_CATALOG_RESPONSE_TO_CHANNEL_CATALOG)) { _ ->
            ChannelCatalogResponseToChannelCatalog(
                get(named(CHANNEL_RESPONSE_TO_CHANNEL))
            )
        }

        single(named(PROGRAM_RESPONSE_TO_PROGRAM)) { _ ->
            ProgramResponseToProgram()
        }

        single(named(PROGRAM_CATALOG_RESPONSE_TO_PROGRAM_CATALOG)) { _ ->
            ProgramCatalogResponseToProgramCatalog(
                get(named(PROGRAM_RESPONSE_TO_PROGRAM))
            )
        }
    }

    private const val CHANNELS_SERVICE: String = "ChannelsService"
    private const val PROGRAMS_SERVICE: String = "ProgramsService"

    val services = module { ->

        single<ChannelsService>(
            named(CHANNELS_SERVICE)
        ) { _ ->
            RetrofitBuilder(
                get(named(MOSHI_HELPER)),
                get(named(INTERCEPTOR_HELPER))
            ).build(androidApplication())
        }

        single<ProgramsService>(
            named(PROGRAMS_SERVICE)
        ) { _ ->
            RetrofitBuilder(
                get(named(MOSHI_HELPER)),
                get(named(INTERCEPTOR_HELPER))
            ).build(androidApplication())
        }

    }

    private const val CHANNELS_REMOTE_DATA_SOURCE: String = "ChannelsRemoteDataSource"
    private const val PROGRAMS_REMOTE_DATA_SOURCE: String = "ProgramsRemoteDataSource"

    val dataSources = module { ->

        single<ChannelsRemoteDataSource>(
            named(CHANNELS_REMOTE_DATA_SOURCE)
        ) { _ ->
            ChannelsRemoteDataSourceImpl(
                get(named(CHANNELS_SERVICE)),
                get(named(CHANNEL_CATALOG_RESPONSE_TO_CHANNEL_CATALOG))
            )
        }

        single<ProgramsRemoteDataSource>(
            named(PROGRAMS_REMOTE_DATA_SOURCE)
        ) { _ ->
            ProgramsRemoteDataSourceImpl(
                get(named(PROGRAMS_SERVICE)),
                get(named(PROGRAM_CATALOG_RESPONSE_TO_PROGRAM_CATALOG))
            )
        }

    }

    const val CHANNELS_REPOSITORY: String = "ChannelsRepository"
    const val PROGRAMS_REPOSITORY: String = "ProgramsRepository"

    val repositories = module { ->

        single<ChannelsRepository>(
            named(CHANNELS_REPOSITORY)
        ) { _ ->
            ChannelsRepositoryImpl(
                get(named(CHANNELS_REMOTE_DATA_SOURCE))
            )
        }

        single<ProgramsRepository>(
            named(PROGRAMS_REPOSITORY)
        ) { _ ->
            ProgramsRepositoryImpl(
                get(named(PROGRAMS_REMOTE_DATA_SOURCE))
            )
        }

    }
}