package com.anzid.core.base

import android.content.Context
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class FragmentViewModelInjection<VM : BaseViewModel> : BaseFragment<VM>(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory
    override val viewModel: VM by lazy { ViewModelProvider(this, viewModelFactory)[getViewModelClass()] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(viewModel)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}