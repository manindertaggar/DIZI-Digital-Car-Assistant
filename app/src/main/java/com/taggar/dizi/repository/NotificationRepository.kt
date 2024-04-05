package com.taggar.dizi.repository

import com.taggar.dizi.models.MusicStatus

interface NotificationRepository {
    fun updateMusicStatus(status: MusicStatus)
    fun getMusicStatus(): List<MusicStatus>
}