package com.anzid.heritage.di.module

import androidx.lifecycle.ViewModel
import com.anzid.core.di.ViewModelKey
import com.anzid.core.di.module.ViewModelFactoryModule
import com.anzid.heritage.addInHeritage.AddInHeritageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AddInHeritageViewModel::class)
    abstract fun bindAddInHeritageViewModel(viewModel: AddInHeritageViewModel): ViewModel
}