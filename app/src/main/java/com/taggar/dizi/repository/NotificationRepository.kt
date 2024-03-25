package com.taggar.dizi.repository

import com.taggar.dizi.base.Outcome
import com.taggar.dizi.models.App
import com.taggar.dizi.models.MusicStatus
import kotlinx.coroutines.flow.Flow

interface NotificationRepository {
    fun updateMusicStatus(status: MusicStatus)
    suspend fun getMusicStatus(): List<MusicStatus>
}