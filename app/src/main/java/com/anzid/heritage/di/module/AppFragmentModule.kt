package com.anzid.heritage.di.module

import com.anzid.heritage.addInHeritage.AddInHeritageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppFragmentModule {

    @ContributesAndroidInjector
    abstract fun bindAddInHeritageFragment(): AddInHeritageFragment
}