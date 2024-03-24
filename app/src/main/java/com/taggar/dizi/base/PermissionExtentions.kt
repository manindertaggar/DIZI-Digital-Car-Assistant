package com.taggar.dizi.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.provider.Settings

fun Activity.openNotificationListenerPermissions() {
    val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
    startActivityForResult(
        intent,
        NOTIFICATION_READER_PERMISSION_CODE
    )
}

fun Context.isNotificationAccessGranted(): Boolean {
    val packageName = packageName
    val flat = Settings.Secure.getString(contentResolver, "enabled_notification_listeners")
    return flat != null && flat.contains(packageName)
}
