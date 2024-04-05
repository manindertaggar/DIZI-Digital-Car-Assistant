package com.taggar.dizi.analytics

import androidx.viewbinding.BuildConfig

fun Exception.log() {
// todo: track on firebase
    if (BuildConfig.DEBUG) {
        printStackTrace()
    }
}