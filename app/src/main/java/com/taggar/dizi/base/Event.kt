package com.taggar.dizi.base

data class Event<T : Any>(
    val value: T
) {

    @get:Synchronized
    private var hasBeenConsumed = false

    fun consume(consumer: (T) -> Unit) {
        if (!hasBeenConsumed) {
            consumer(value)
            hasBeenConsumed = true
        }
    }
}

fun <T : Any> T.toEvent() = Event(this)
