package com.taggar.dizi.ui

import androidx.navigation.NavHostController

enum class Route(val path: String) {
    Home("home"),
    PermissionNotificationReader("permission-notification-reader")
}

fun NavHostController.navigate(route: Route) {
    navigate(route.path)
}