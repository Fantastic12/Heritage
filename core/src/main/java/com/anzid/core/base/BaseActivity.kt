package com.anzid.core.base

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.anzid.core.util.LanguageHelper

abstract class BaseActivity : AppCompatActivity() {

    @get: LayoutRes
    protected abstract val activityLayout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityLayout)

        initListeners()
        initObservers()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(LanguageHelper.onAttach(base))
    }

    protected open fun initListeners() {}
    protected open fun initObservers() {}
}
