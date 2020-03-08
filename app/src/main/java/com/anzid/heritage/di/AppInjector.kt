package com.anzid.heritage.di

import com.anzid.heritage.HeritageApp

object AppInjector {

    private lateinit var appComponent: AppComponent

    fun provideAppComponent(app: HeritageApp): AppComponent {
        if (AppInjector::appComponent.isInitialized.not()) {
            appComponent = DaggerAppComponent
                .builder()
                .application(app)
                .build()
        }

        return appComponent
    }

    fun getAppComponent() = appComponent
}