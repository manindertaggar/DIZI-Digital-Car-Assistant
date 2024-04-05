package com.taggar.dizi.models

import android.app.PendingIntent
import android.graphics.drawable.Icon

data class MusicStatus(
    val isPlaying: Boolean,
    val actions: Map<String, PendingIntent>,
    val icon: Icon,
    val title: String,
    val packageName: String
) {
    fun toSimple() = MusicStatusSimple(isPlaying, packageName)
}

data class MusicStatusSimple(
    val isPlaying: Boolean,
    val packageName: String
)