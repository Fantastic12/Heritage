package com.anzid.core.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.anzid.core.ResourceProvider
import javax.inject.Inject

/**
 * Created by Nazariy Yatsuk on 17.07.2019.
 * Copyright (c) 2019 ANZID Company. All rights reserved.
 */

abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    @Inject
    protected lateinit var resourceProvider: ResourceProvider

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected open fun onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected open fun onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected open fun onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected open fun onStop() {
    }
}