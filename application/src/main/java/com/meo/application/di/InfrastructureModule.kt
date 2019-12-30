package com.meo.application.di

import com.meo.infrastructure.helpers.*
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

object InfrastructureModule {

    const val MOSHI_HELPER: String = "MoshiHelper"
    const val INTERCEPTOR_HELPER: String = "InterceptorHelper"
    const val NETWORK_CONNECTION_HELPER: String = "NetworkConnectionHelper"

    val helpersModules = module { ->

        single<MoshiHelper>(named(MOSHI_HELPER)) { _ ->
            MoshiHelperImpl()
        }

        single<InterceptorHelper>(named(INTERCEPTOR_HELPER)) { _ ->
            InterceptorHelperImpl()
        }

        single<NetworkConnection>(named(NETWORK_CONNECTION_HELPER)) { _ ->
            NetworkConnectionImpl(
                androidApplication()
            )
        }
    }
}