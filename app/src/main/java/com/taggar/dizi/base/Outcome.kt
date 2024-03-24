package com.taggar.dizi.base

sealed class Outcome<out TResult : Any> {
    data class Error(val message: String = "", val failure: Failure? = null) : Outcome<Nothing>()
    data class Success<out TResult : Any>(val value: TResult) : Outcome<TResult>()
}
