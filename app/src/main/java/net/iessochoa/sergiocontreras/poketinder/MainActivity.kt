package net.iessochoa.sergiocontreras.poketinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import net.iessochoa.sergiocontreras.poketinder.ui.screens.CapturesScreen
import net.iessochoa.sergiocontreras.poketinder.ui.screens.HuntScreen
import net.iessochoa.sergiocontreras.poketinder.model.Pokemon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentScreen by remember { mutableStateOf("encuentros") }
            val capturedPokemon = remember { mutableStateListOf<Pokemon>() }

            when (currentScreen) {
                "encuentros" -> HuntScreen(
                    onNavigateToCapturas = { currentScreen = "capturas" }
                )
                "capturas" -> CapturesScreen(
                    capturedPokemon = capturedPokemon,
                    onBack = { currentScreen = "encuentros" }
                )
            }
        }
    }
}