package com.github.sun5066.core_network.datasource

import com.github.sun5066.common_model.CharacterInfo
import kotlinx.coroutines.flow.Flow

interface AdventureTimeRemoteDataSource {

    fun getCharacters(): Flow<List<CharacterInfo>>

}