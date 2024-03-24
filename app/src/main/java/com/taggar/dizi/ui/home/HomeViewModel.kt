package com.taggar.dizi.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taggar.dizi.usecases.GetMusicStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    val getMusicStatus: GetMusicStatus
) : ViewModel() {
    val state = MutableStateFlow(HomeState())
    init {
        viewModelScope.launch {
            getMusicStatus(Unit).collect { musicStatus ->
                state.value = state.value.copy(music = musicStatus)
            }
        }
    }
}