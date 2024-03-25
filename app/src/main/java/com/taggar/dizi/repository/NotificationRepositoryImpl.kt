package com.taggar.dizi.repository

import android.content.Context
import android.service.notification.NotificationListenerService
import android.util.Log
import com.taggar.dizi.base.Outcome
import com.taggar.dizi.models.App
import com.taggar.dizi.models.MusicStatus
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext
import javax.inject.Inject


class NotificationRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : NotificationRepository {
    private val TAG = NotificationRepositoryImpl::class.simpleName
    private var musicStatus = hashMapOf<String, MusicStatus>()

    override fun updateMusicStatus(status: MusicStatus) {
        Log.d(TAG, "status: $status")
        musicStatus[status.packageName] = status
    }

    override suspend fun getMusicStatus(): List<MusicStatus> {
        Log.d(TAG, "getMusicStatus")
        return musicStatus.values.sortedBy { it.isPlaying }
    }
}