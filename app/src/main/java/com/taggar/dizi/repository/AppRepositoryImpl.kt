package com.taggar.dizi.repository

import android.content.Context
import com.taggar.dizi.models.App
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class AppRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : AppRepository {
    override suspend fun getApps(): Map<String, List<App>> = withContext(Dispatchers.IO) {
        throw Exception()
    }
}