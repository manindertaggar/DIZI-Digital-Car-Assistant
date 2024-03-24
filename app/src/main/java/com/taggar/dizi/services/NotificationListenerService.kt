package com.taggar.dizi.services

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NotificationListenerService : NotificationListenerService() {
    private val TAG = NotificationListenerService::class.java.simpleName
    override fun onCreate() {
        super.onCreate()
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        // Called when a new notification is posted
        Log.d(TAG, "New notification posted: ${sbn.packageName} - ${sbn.notification?.tickerText}")
        // You can access notification information such as package name, title, and content here
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        // Called when a notification is removed
        Log.d(TAG, "Notification removed: ${sbn.packageName}")
    }
}