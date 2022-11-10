package com.github.sun5066.core_network.datasource

import com.github.sun5066.core_network.service.AdventureTimeCharacterInfoService
import com.github.sun5066.common_model.CharacterInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AdventureTimeRemoteDataSourceImpl @Inject constructor(
    private val adventureTimeCharacterInfoService: AdventureTimeCharacterInfoService
) : AdventureTimeRemoteDataSource {
    override fun getCharacters(): Flow<List<CharacterInfo>> =
        adventureTimeCharacterInfoService.getCharacters()
}