package com.github.sun5066.core_data.repository

import com.github.sun5066.common_model.CharacterInfo
import kotlinx.coroutines.flow.Flow

interface AdventureTimeRepository {
    fun getCharacters(): Flow<List<CharacterInfo>>
}