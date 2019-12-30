package com.meo.application.di

import com.meo.application.di.DataModule.CHANNELS_REPOSITORY
import com.meo.application.di.DataModule.PROGRAMS_REPOSITORY
import com.meo.application.usecases.ChannelsUseCaseImpl
import com.meo.application.usecases.ProgramsUseCaseImpl
import com.meo.domain.usecases.ChannelsUseCase
import com.meo.domain.usecases.ProgramsUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

object ApplicationModule {

    const val CHANNELS_USE_CASE: String = "ChannelsUseCase"
    const val PROGRAMS_USE_CASE: String = "ProgramsUseCase"

    val useCase = module { ->

        single<ChannelsUseCase>(
            named(CHANNELS_USE_CASE)
        ) { _ ->
            ChannelsUseCaseImpl(
                get(named(CHANNELS_REPOSITORY))
            )
        }

        single<ProgramsUseCase>(
            named(PROGRAMS_USE_CASE)
        ) { _ ->
            ProgramsUseCaseImpl(
                get(named(PROGRAMS_REPOSITORY))
            )
        }

    }
}