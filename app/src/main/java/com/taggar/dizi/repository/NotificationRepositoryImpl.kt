package com.taggar.dizi.repository

import android.content.Context
import android.util.Log
import com.taggar.dizi.models.MusicStatus
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
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

    override fun getMusicStatus(): Flow<List<MusicStatus>> = channelFlow {
        Log.d(TAG, "getMusicStatus")
        musicStatus.values.sortedBy { it.isPlaying }
    }
}