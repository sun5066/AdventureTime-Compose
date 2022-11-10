package com.github.sun5066.common_model

data class CharacterInfo(
    val id: Int = 0,
    val slug: String = "",
    val displayName: String = "",
    val fullName: String = "",
    val sex: String = "",
    private val quotes: List<String> = listOf(""),
    val sprite: String = ""
)