package com.github.sun5066.core_data.usecase

import com.github.sun5066.core_data.repository.AdventureTimeRepository
import com.github.sun5066.core_data.state.resultFlow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val adventureTimeRepository: AdventureTimeRepository
) {

    operator fun invoke() = adventureTimeRepository.getCharacters().resultFlow

}