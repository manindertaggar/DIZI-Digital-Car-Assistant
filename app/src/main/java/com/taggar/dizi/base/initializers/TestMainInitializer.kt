package com.taggar.dizi.base.initializers

import com.taggar.dizi.base.initializers.core.AppInitializer
import com.taggar.dizi.base.initializers.core.AppMainInitializer
import javax.inject.Inject

class TestMainInitializer @Inject constructor(
) : AppMainInitializer {
    override suspend fun initialize() {

    }
}

class TestInitializer @Inject constructor(
) : AppInitializer {
    override suspend fun initialize() {

    }
}