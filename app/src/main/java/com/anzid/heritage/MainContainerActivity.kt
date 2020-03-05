package com.anzid.heritage

import android.os.Bundle
import com.anzid.core.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main_container.*
import kotlinx.android.synthetic.main.item_list.*

class MainContainerActivity : BaseActivity() {

    override val activityLayout = R.layout.activity_main_container

    private var twoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initToolBar()
        if (item_detail_container != null) twoPane = true
    }

    private fun initToolBar() {
        setSupportActionBar(toolbar)
        toolbar.title = title
    }

    override fun initListeners() {
    }
}
