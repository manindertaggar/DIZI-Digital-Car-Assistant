package com.taggar.dizi.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taggar.dizi.repository.NotificationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val notificationRepository: NotificationRepository
) : ViewModel() {
    private val TAG = HomeViewModel::class.simpleName
    val state = MutableStateFlow(HomeState())

    init {
        viewModelScope.launch {
            notificationRepository.getMusicStatus().collect {
                Log.d(TAG, "getMusicStatus: $it")
            }
        }
    }
}