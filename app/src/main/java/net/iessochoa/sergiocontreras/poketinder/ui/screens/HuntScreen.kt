package net.iessochoa.sergiocontreras.poketinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.poketinder.model.PokemonRepository
import net.iessochoa.sergiocontreras.poketinder.ui.components.PokemonCard

@Composable
fun HuntScreen(
    uiState: HuntScreenUiState,
    onNavigateToCapturas: () -> Unit
) {


    //var currentPokemon by remember { mutableStateOf(PokemonRepository.getRandomPokemon()) }
    //var pokeBalls by remember { mutableStateOf(5) }
    // var huidas by remember { mutableStateOf(2) }

    val currentPokemon = uiState.currentPokemon
    val pokeBalls = uiState.pokeballsLeft
    val huidas = uiState.escapesLeft


    val swipeLeft = {
            if (huidas > 0) {
                huidas--
                currentPokemon = PokemonRepository.getRandomPokemon()
            }
    }

    val swipeRight = {
        if (pokeBalls > 0) {
            pokeBalls--
            // Aquí iría la lógica para capturar
            currentPokemon = PokemonRepository.getRandomPokemon()
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (pokeBalls > 0) {
            PokemonCard(pokemon = currentPokemon, allowSwipe = false, onLike = swipeRight, onDislike = swipeLeft)
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(onClick = swipeLeft) {
                    Text(text = "Huir ($huidas)")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = swipeRight) {
                    Text(text = "Capturar ($pokeBalls)")
                }
            }
        } else {
            Text(text = "No te quedan más intentos")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToCapturas) {
            Text(text = "Mis capturas")
        }
    }
}

