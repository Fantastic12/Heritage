package com.anzid.heritage.di.module

import com.anzid.heritage.di.AppScope
import com.anzid.heritage.repository.HeritageRepository
import com.anzid.heritage.repository.HeritageRepositoryImp
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @AppScope
    @Binds
    abstract fun bindHeritageRepository(repository: HeritageRepositoryImp): HeritageRepository
}