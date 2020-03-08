package com.anzid.core.di

import android.app.Application
import com.anzid.core.db.datasource.LocalDbDataSource
import com.anzid.core.di.module.DataSourceModule
import com.anzid.core.di.module.DbModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@CoreScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        DbModule::class,
        DataSourceModule::class
    ]
)
interface CoreComponent : AndroidInjector<Application> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CoreComponent
    }

    fun getLocalDbDataSource(): LocalDbDataSource

}