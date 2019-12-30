package com.meo.go.di

import com.meo.application.di.ApplicationModule.CHANNELS_USE_CASE
import com.meo.application.di.ApplicationModule.PROGRAMS_USE_CASE
import com.meo.application.di.InfrastructureModule.NETWORK_CONNECTION_HELPER
import com.meo.go.features.home.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object AppModules {

    val viewModel = module { ->

        viewModel { _ ->
            HomeScreenViewModel(
                get(named(NETWORK_CONNECTION_HELPER)),
                get(named(CHANNELS_USE_CASE)),
                get(named(PROGRAMS_USE_CASE))
            )
        }

    }

}