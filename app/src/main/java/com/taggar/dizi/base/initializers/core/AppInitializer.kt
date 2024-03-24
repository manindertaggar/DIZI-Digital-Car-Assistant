package com.taggar.dizi.base.initializers.core

interface AppInitializer {
    suspend fun initialize()
}

interface AppMainInitializer : AppInitializer
