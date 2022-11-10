package com.github.sun5066.core_data.di

import com.github.sun5066.core_data.repository.AdventureTimeRepository
import com.github.sun5066.core_data.repository.AdventureTimeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsAdventureTimeRepository(adventureTimeRepository: AdventureTimeRepositoryImpl): AdventureTimeRepository

}