package com.taggar.dizi.repository

import android.util.Log
import com.taggar.dizi.models.MusicStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

class MusicStatusUpdatePersistence @Inject constructor() {
    private val TAG = MusicStatusUpdatePersistence::class.simpleName
    private val _dataFlow = MutableStateFlow<MusicStatus?>(null)
    private val dataFlow: Flow<MusicStatus> = _dataFlow.filterNotNull()
    fun update(status: MusicStatus) {
        Log.d(TAG, "update: ${status.packageName}: isPlaying: ${status.isPlaying}")
        _dataFlow.value = status
    }

    fun listen() = dataFlow
}