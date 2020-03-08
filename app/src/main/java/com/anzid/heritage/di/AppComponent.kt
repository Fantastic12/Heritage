package com.anzid.heritage.di

import com.anzid.heritage.HeritageApp
import com.anzid.heritage.di.module.AppActivityModule
import com.anzid.heritage.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        AppActivityModule::class
    ]
)
interface AppComponent : AndroidInjector<HeritageApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: HeritageApp): Builder

        fun build(): AppComponent
    }

}