package com.taggar.dizi.repository

import com.taggar.dizi.models.App

interface AppRepository {
    suspend fun getApps(): Map<String, List<App>>
}