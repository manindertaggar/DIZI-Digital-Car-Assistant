package com.taggar.dizi.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taggar.dizi.repository.MusicStatusUpdatePersistence
import com.taggar.dizi.repository.NotificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val musicStatusUpdatePersistence: MusicStatusUpdatePersistence,
    private val notificationRepository: NotificationRepository
) : ViewModel() {
    val state = MutableStateFlow(HomeState())

    init {
        viewModelScope.launch {
            musicStatusUpdatePersistence.listen().collect { status ->
                state.value = state.value.copy(lastMusicStatus = status)
            }
        }
    }

    fun getMusicStatusByPackage(packageName: String) {
        notificationRepository.getMusicStatus().find { packageName == it.packageName }
    }
}