package com.github.sun5066.core_data.repository

import com.github.sun5066.common_model.CharacterInfo
import com.github.sun5066.core_network.datasource.AdventureTimeRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AdventureTimeRepositoryImpl @Inject constructor(
    private val adventureTimeRemoteDataSource: AdventureTimeRemoteDataSource
) : AdventureTimeRepository {

    override fun getCharacters(): Flow<List<CharacterInfo>> =
        adventureTimeRemoteDataSource.getCharacters()

}