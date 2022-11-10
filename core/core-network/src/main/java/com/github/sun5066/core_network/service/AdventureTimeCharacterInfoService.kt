package com.github.sun5066.core_network.service

import com.github.sun5066.common_model.CharacterInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface AdventureTimeCharacterInfoService {

    @GET("characters")
    fun getCharacters(): Flow<List<CharacterInfo>>

}