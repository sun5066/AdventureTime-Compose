package com.github.sun5066.adventure_time.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.sun5066.core_data.state.Result
import com.github.sun5066.core_data.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    val charactersState = getCharactersUseCase.invoke()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = Result.Loading
        )

}