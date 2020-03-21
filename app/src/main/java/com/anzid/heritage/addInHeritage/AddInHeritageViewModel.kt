package com.anzid.heritage.addInHeritage

import androidx.annotation.StringRes
import androidx.lifecycle.MutableLiveData
import com.anzid.annotation.PublicLiveData
import com.anzid.core.SingleLiveEvent
import com.anzid.core.base.BaseViewModel
import com.anzid.heritage.R
import com.anzid.heritage.model.PersonModel
import com.anzid.heritage.repository.HeritageRepository
import javax.inject.Inject

class AddInHeritageViewModel @Inject constructor(private val heritageRepository: HeritageRepository) : BaseViewModel() {

    @PublicLiveData private var _showToast = SingleLiveEvent<@StringRes Int>()
    @PublicLiveData private var _showSnack = SingleLiveEvent<PersonModel>()
    @PublicLiveData private var _showSnack2 = MutableLiveData<Unit>()
    @PublicLiveData private var _showSnack3 = SingleLiveEvent<Any>()
    @PublicLiveData private var _showDialog = SingleLiveEvent<Boolean>()
    @PublicLiveData private var _showDialog1 = MutableLiveData<Float>()
    @PublicLiveData private var _showDialog2 = SingleLiveEvent<List<Boolean>>()
    @PublicLiveData private var _showDialog3 = MutableLiveData<Long>()

    fun show() {
        _showToast.postValue(R.string.app_name)
    }
}
