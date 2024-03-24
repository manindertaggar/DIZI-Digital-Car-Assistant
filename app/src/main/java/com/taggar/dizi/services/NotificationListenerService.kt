package com.taggar.dizi.services

import android.app.PendingIntent
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log
import com.taggar.dizi.models.MusicStatus

class NotificationListenerService : NotificationListenerService() {
    private val TAG = NotificationListenerService::class.java.simpleName
    override fun onCreate() {
        super.onCreate()
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        Log.d(TAG, "New notification posted: ${sbn.packageName} - ${sbn.notification?.tickerText}")
        if (
            sbn.notification.extras.getString("android.template")
                ?.equals("android.app.Notification\$MediaStyle") == false ||
            sbn.notification.actions.find { it.title.equals("Pause") || it.title.equals("Play") } == null
        ) {
            return
        }
        val actions = hashMapOf<String, PendingIntent>()
        sbn.notification.actions.forEach {
            val intent = it.actionIntent
            val title = it.title.toString()
            actions[title] = intent
        }
        val musicStatus = MusicStatus(
            isPlaying = sbn.notification.actions.find { it.title.equals("Pause") } != null,
            actions = actions,
            icon = sbn.notification.getLargeIcon(),
            title = sbn.notification.extras.getString("android.title") ?: "",
            packageName = sbn.packageName
        )
        Log.d(TAG, "Found Music: $musicStatus")
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        Log.d(TAG, "Notification removed: ${sbn.packageName}")
    }
}