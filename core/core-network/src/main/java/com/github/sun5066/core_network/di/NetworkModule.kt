package com.github.sun5066.core_network.di

import com.github.sun5066.core_network.service.AdventureTimeCharacterInfoService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import tech.thdev.network.flowcalladapterfactory.FlowCallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val providesAdventureTimeCharacterInfoUrl =
        "https://adventure-time-api.herokuapp.com/api/v1/"

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .build()

    @Singleton
    @Provides
    fun providesRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder =
        Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(FlowCallAdapterFactory())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))

    @Singleton
    @Provides
    fun providesAdventureTimeCharacterInfoService(
        retrofit: Retrofit.Builder
    ): AdventureTimeCharacterInfoService = retrofit
        .baseUrl(providesAdventureTimeCharacterInfoUrl)
        .build()
        .create(AdventureTimeCharacterInfoService::class.java)

}