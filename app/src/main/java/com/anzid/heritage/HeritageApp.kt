package com.anzid.heritage

import android.app.Application
import com.anzid.heritage.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class HeritageApp : Application(), HasAndroidInjector {

    @Volatile
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()
        AppInjector.provideAppComponent(this)
    }
}
