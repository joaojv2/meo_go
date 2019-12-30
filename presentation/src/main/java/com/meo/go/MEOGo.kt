package com.meo.go

import android.app.Application
import com.meo.go.di.AppComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MEOGo : Application() {

    override fun onCreate() {
        super.onCreate()
        initInjections()
    }

    private fun initInjections() {
        startKoin { ->
            androidLogger()
            androidContext(this@MEOGo)
            modules(AppComponent.allModules())
        }
    }
}