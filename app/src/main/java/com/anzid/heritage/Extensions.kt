package com.anzid.heritage

import android.app.Activity

fun Activity.hideOrShowMainToolbar(visibility: Boolean) {
    if (this is MainContainerActivity) hideOrShowToolbar(visibility)
    else throw Throwable("Activity not MainContainerActivity")
}