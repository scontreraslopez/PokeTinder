package net.iessochoa.sergiocontreras.poketinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import net.iessochoa.sergiocontreras.poketinder.ui.screens.CapturasScreen
import net.iessochoa.sergiocontreras.poketinder.ui.screens.EncuentrosScreen
import net.iessochoa.sergiocontreras.poketinder.model.Pokemon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentScreen by remember { mutableStateOf("encuentros") }
            val capturedPokemon = remember { mutableStateListOf<Pokemon>() }

            when (currentScreen) {
                "encuentros" -> EncuentrosScreen(
                    onNavigateToCapturas = { currentScreen = "capturas" }
                )
                "capturas" -> CapturasScreen(
                    capturedPokemon = capturedPokemon,
                    onBack = { currentScreen = "encuentros" }
                )
            }
        }
    }
}