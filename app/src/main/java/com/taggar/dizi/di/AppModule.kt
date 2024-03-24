package com.taggar.dizi.di

import com.taggar.dizi.analytics.Analytics
import com.taggar.dizi.analytics.AnalyticsImpl
import com.taggar.dizi.base.initializers.TestInitializer
import com.taggar.dizi.base.initializers.TestMainInitializer
import com.taggar.dizi.base.initializers.core.AppInitializer
import com.taggar.dizi.base.initializers.core.AppMainInitializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @IntoSet
    abstract fun testAppMainInitializer(initializer: TestMainInitializer): AppMainInitializer

    @Binds
    @IntoSet
    abstract fun testAppInitializer(initializer: TestInitializer): AppInitializer

    @Binds
    abstract fun initializeAnalytics(analytics: AnalyticsImpl): Analytics
}