package com.taggar.dizi.ui.home

data class HomeState(
    val music: MusicStatus = MusicStatus(isPlaying = false)
)

data class MusicStatus(
    val isPlaying: Boolean
)