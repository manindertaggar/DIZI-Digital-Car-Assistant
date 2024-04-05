package com.taggar.dizi.repository

import com.taggar.dizi.models.MusicStatusSimple
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject

class MusicStatusUpdatePersistence @Inject constructor() {
    private val _dataFlow = MutableStateFlow<MusicStatusSimple?>(null)
    private val dataFlow: Flow<MusicStatusSimple> = _dataFlow.filterNotNull()
    fun update(status: MusicStatusSimple) {
        _dataFlow.value = status
    }

    fun listen() = dataFlow
}