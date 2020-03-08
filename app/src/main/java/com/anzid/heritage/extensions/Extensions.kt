package com.anzid.heritage.extensions

import android.app.Activity
import android.view.View
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.anzid.heritage.MainContainerActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun Activity.hideOrShowMainToolbar(visibility: Boolean) {
    if (this is MainContainerActivity) hideOrShowToolbar(visibility)
    else throw Throwable("Activity not MainContainerActivity")
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun SwipeRefreshLayout.startRefreshing() {
    isRefreshing = true
}

fun SwipeRefreshLayout.stopRefreshing() {
    isRefreshing = false
}

fun ImageView.loadImage(url: String) = Glide.with(this)
    .load(url)
    .into(this)

fun ImageView.loadImageRound(url: String) = Glide.with(this)
    .load(url)
    .apply(RequestOptions.circleCropTransform())
    .into(this)