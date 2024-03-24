package com.taggar.dizi

import android.app.Application
import com.taggar.dizi.base.initializers.core.InitializeApplication
import com.taggar.dizi.usecases.base.invoke
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication : Application() {

    @Inject
    lateinit var initializeApp: InitializeApplication

    override fun onCreate() {
        super.onCreate()
        runBlocking { initializeApp.invoke() }
    }
}