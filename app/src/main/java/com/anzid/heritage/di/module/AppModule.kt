package com.anzid.heritage.di.module

import android.content.Context
import androidx.annotation.NonNull
import com.anzid.heritage.HeritageApp
import com.anzid.heritage.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @AppScope
    @Provides
    @NonNull
    fun provideContext(application: HeritageApp): Context = application

}