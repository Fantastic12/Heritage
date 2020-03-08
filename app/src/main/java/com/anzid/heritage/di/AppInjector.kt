package com.anzid.heritage.di

import com.anzid.core.di.CoreInjector
import com.anzid.heritage.HeritageApp

object AppInjector {

    private lateinit var appComponent: AppComponent

    fun provideAppComponent(app: HeritageApp): AppComponent {
        if (AppInjector::appComponent.isInitialized.not()) {
            appComponent = DaggerAppComponent
                .builder()
                .application(app)
                .initCoreComponent(CoreInjector.provideAppComponent(app))
                .build()
        }

        return appComponent
    }

    fun getAppComponent() = appComponent
}