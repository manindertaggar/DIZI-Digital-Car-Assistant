package com.taggar.dizi.di

import com.taggar.dizi.repository.NotificationRepository
import com.taggar.dizi.repository.NotificationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton

@InstallIn(ViewModelComponent::class, ServiceComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun binds(repository: NotificationRepositoryImpl): NotificationRepository
}