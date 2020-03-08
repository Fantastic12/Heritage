package com.anzid.heritage.di.module

import com.anzid.heritage.MainContainerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [AppFragmentModule::class])
abstract class AppActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainContainerActivity(): MainContainerActivity
}