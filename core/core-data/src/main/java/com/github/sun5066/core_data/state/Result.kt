package com.github.sun5066.core_data.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val error: Throwable? = null) : Result<Nothing>
    object Loading : Result<Nothing>
}

internal val <T> Flow<T>.resultFlow: Flow<Result<T>>
    get() = map<T, Result<T>> { Result.Success(it) }
        .onStart { emit(Result.Loading) }
        .catch { emit(Result.Error(it)) }