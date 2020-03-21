package com.anzid.heritage.list

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.anzid.annotation.PublicLiveData
import com.anzid.core.SingleLiveEvent
import com.anzid.heritage.model.PersonModel

class ListPersonFomHeritageViewModel : ViewModel() {

    @PublicLiveData private var _showToast = SingleLiveEvent<@StringRes Int>()
    @PublicLiveData private var _showSnack = SingleLiveEvent<PersonModel>()
}
