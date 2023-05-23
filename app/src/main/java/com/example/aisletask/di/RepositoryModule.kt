package com.example.aisletask.di

import com.example.aisletask.network.ApiClient
import com.example.aisletask.repository.MyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideMyRepository(apiClient: ApiClient): MyRepository {
        return MyRepository(apiClient)
    }
}