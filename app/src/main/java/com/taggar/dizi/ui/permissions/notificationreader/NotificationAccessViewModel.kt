package com.taggar.dizi.ui.permissions.notificationreader

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.taggar.dizi.base.isNotificationAccessGranted
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class NotificationAccessViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {
    val state = MutableStateFlow(NotificationAccessState())
    val TAG = NotificationAccessViewModel::class.simpleName

    init {
        updatePermissionState()
    }

    private fun updatePermissionState() {
        val isPermissionAllowed = context.isNotificationAccessGranted()
        Log.d(TAG, "isPermissionAllowed: $isPermissionAllowed")
        state.value = state.value.copy(
            isPermissionAllowed = isPermissionAllowed
        )
    }
}