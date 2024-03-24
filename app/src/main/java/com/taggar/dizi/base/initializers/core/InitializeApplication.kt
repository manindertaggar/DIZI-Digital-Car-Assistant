package com.taggar.dizi.base.initializers.core


import com.taggar.dizi.usecases.base.Usecase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class InitializeApplication @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards AppInitializer>,
    private val mainInitializers: Set<@JvmSuppressWildcards AppMainInitializer>,
) : Usecase<Unit, Unit> {

    override suspend fun invoke(param: Unit) = coroutineScope {
        mainInitializers.forEach { it.initialize() }
        initializers.forEach {
            launch(Dispatchers.Default) {
                it.initialize()
            }
        }
    }
}
