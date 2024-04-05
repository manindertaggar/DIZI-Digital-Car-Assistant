package com.taggar.dizi.di

import com.taggar.dizi.repository.MusicStatusUpdatePersistence
import com.taggar.dizi.repository.NotificationRepository
import com.taggar.dizi.repository.NotificationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun notificationRepository(repository: NotificationRepositoryImpl): NotificationRepository

    companion object {
        @Provides
        fun provideMusicStatusPersistence() = MusicStatusUpdatePersistence()
    }
}
