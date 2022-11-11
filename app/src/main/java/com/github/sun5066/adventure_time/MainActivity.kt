package com.github.sun5066.adventure_time

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.github.sun5066.adventure_time.ui.home.CharacterInfoApp
import com.github.sun5066.adventure_time.ui.theme.AdventureTimeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdventureTimeTheme {
                Surface(color = MaterialTheme.colors.surface) {
                    CharacterInfoApp()
                }
            }
        }
    }
}