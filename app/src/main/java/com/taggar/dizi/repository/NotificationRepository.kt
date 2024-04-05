package com.taggar.dizi.repository

import com.taggar.dizi.models.MusicStatus
import kotlinx.coroutines.flow.Flow

interface NotificationRepository {
    fun updateMusicStatus(status: MusicStatus)
    fun getMusicStatus(): Flow<List<MusicStatus>>
}