package com.anzid.core.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    @get: LayoutRes
    protected abstract val activityLayout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityLayout)

        initListeners()
        initObservers()
    }

    protected open fun initListeners() {}
    protected open fun initObservers() {}
}
