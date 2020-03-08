package com.anzid.heritage.di

import com.anzid.core.di.CoreComponent
import com.anzid.heritage.HeritageApp
import com.anzid.heritage.di.module.AppActivityModule
import com.anzid.heritage.di.module.AppModule
import com.anzid.heritage.di.module.RepositoryModule
import com.anzid.heritage.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        AppActivityModule::class,
        ViewModelModule::class,
        RepositoryModule::class
    ], dependencies = [CoreComponent::class]
)
interface AppComponent : AndroidInjector<HeritageApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: HeritageApp): Builder
        fun initCoreComponent(component: CoreComponent): Builder
        fun build(): AppComponent
    }
}