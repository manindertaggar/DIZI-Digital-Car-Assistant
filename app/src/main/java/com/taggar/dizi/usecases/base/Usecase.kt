package com.taggar.dizi.usecases.base

interface Usecase<TParam, TResult> {
    suspend operator fun invoke(param: TParam): TResult
}

suspend operator fun <T> Usecase<Unit, T>.invoke() = invoke(Unit)
