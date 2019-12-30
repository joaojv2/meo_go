package com.meo.go.di

import com.meo.application.di.ApplicationModule
import com.meo.application.di.DataModule
import com.meo.application.di.InfrastructureModule
import org.koin.core.module.Module

object AppComponent {

    fun allModules(): List<Module> {
        return listOf(
            *appModules(),
            *applicationModules(),
            *dataModules(),
            *infrastructureModules()
        )
    }

    private fun appModules(): Array<Module> {
        return arrayOf(
            AppModules.viewModel
        )
    }


    private fun applicationModules(): Array<Module> {
        return arrayOf(
            ApplicationModule.useCase
        )
    }

    private fun dataModules(): Array<Module> {
        return arrayOf(
            DataModule.mappers,
            DataModule.services,
            DataModule.dataSources,
            DataModule.repositories
        )
    }

    private fun infrastructureModules(): Array<Module> {
        return arrayOf(
            InfrastructureModule.helpersModules
        )
    }
}