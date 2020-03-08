package com.anzid.core.di.module

import com.anzid.core.db.datasource.LocalDbDataSource
import com.anzid.core.db.datasource.LocalDbDataSourceImpl
import com.anzid.core.di.CoreScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class DataSourceModule {

    @CoreScope
    @Binds
    abstract fun bindLocalDbDataSource(localDbDataSource: LocalDbDataSourceImpl): LocalDbDataSource
}