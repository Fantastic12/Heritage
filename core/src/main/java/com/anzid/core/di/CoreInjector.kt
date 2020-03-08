package com.anzid.core.di

import android.app.Application

object CoreInjector {

    private lateinit var coreComponent: CoreComponent

    fun provideAppComponent(app: Application): CoreComponent {
        if (CoreInjector::coreComponent.isInitialized.not()) {
            coreComponent = DaggerCoreComponent
                .builder()
                .application(app)
                .build()
        }

        return coreComponent
    }

    fun getCoreComponent() = coreComponent
}