package com.anzid.core.di.module

import com.anzid.core.db.datasource.LocalDbDataSource
import com.anzid.core.db.datasource.LocalDbDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSourceModule {

    @Binds
    abstract fun bindLocalDbDataSource(localDbDataSource: LocalDbDataSourceImpl): LocalDbDataSource
}