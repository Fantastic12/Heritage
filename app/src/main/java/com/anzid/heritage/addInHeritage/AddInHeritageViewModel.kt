package com.anzid.heritage.addInHeritage

import androidx.annotation.StringRes
import com.anzid.annotation.PublicLiveData
import com.anzid.core.SingleLiveEvent
import com.anzid.core.base.BaseViewModel
import com.anzid.heritage.R
import com.anzid.heritage.repository.HeritageRepository
import javax.inject.Inject

class AddInHeritageViewModel @Inject constructor(private val heritageRepository: HeritageRepository) : BaseViewModel() {

    @PublicLiveData private var _showToast = SingleLiveEvent<@StringRes Int>()

    fun show() {
        _showToast.postValue(R.string.app_name)
    }
}
