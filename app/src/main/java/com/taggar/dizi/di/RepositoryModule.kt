package com.taggar.dizi.di

import com.taggar.dizi.repository.AppRepository
import com.taggar.dizi.repository.AppRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun binds(repository: AppRepositoryImpl): AppRepository
}