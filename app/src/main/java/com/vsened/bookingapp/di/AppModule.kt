package com.vsened.bookingapp.di

import com.vsened.bookingapp.data.local.AppDatabase
import com.vsened.bookingapp.data.remote.AppApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppApi(): AppApi {
        return AppApi()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase {
        return AppDatabase()
    }
}