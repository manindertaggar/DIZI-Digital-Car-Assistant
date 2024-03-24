package com.taggar.dizi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.taggar.dizi.ui.Route
import com.taggar.dizi.ui.Route.Home
import com.taggar.dizi.ui.Route.PermissionNotificationReader
import com.taggar.dizi.ui.home.Home
import com.taggar.dizi.ui.permissions.notificationreader.NotificationReader
import com.taggar.dizi.ui.theme.BaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaseTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Home.path
                    ) {
                        composable(Home.path) {
                            Home(navController = navController)
                        }
                        composable(PermissionNotificationReader.path) {
                            NotificationReader(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
