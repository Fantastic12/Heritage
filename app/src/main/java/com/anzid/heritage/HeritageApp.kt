package com.anzid.heritage

import com.anzid.heritage.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class HeritageApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return AppInjector.provideAppComponent(this)
    }
}
