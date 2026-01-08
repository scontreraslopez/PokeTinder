package net.iessochoa.sergiocontreras.poketinder.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import net.iessochoa.sergiocontreras.poketinder.model.Pokemon
import net.iessochoa.sergiocontreras.poketinder.ui.screens.CapturesScreen
import net.iessochoa.sergiocontreras.poketinder.ui.screens.HuntScreenViewModel
import net.iessochoa.sergiocontreras.poketinder.ui.screens.HuntScreen

@Composable
fun PokeTinderApp(
    viewModel: HuntScreenViewModel = viewModel(),
    modifier: Modifier = Modifier
) {

    val uiState by viewModel.uistate.collectAsStateWithLifecycle()


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