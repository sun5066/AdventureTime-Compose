package com.github.sun5066.core_network.di

import com.github.sun5066.core_network.datasource.AdventureTimeRemoteDataSource
import com.github.sun5066.core_network.datasource.AdventureTimeRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindsAdventureTimeRemoteDataSource(
        adventureTimeRemoteDataSource: AdventureTimeRemoteDataSourceImpl
    ): AdventureTimeRemoteDataSource

}