package com.anzid.core.di.module

import android.app.Application
import com.anzid.core.db.HeritageDb
import com.anzid.core.di.CoreScope
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @CoreScope
    @Provides
    fun provideHeritageDb(application: Application) = HeritageDb.getDatabase(application)

}