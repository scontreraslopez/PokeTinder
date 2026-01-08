package net.iessochoa.sergiocontreras.poketinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import net.iessochoa.sergiocontreras.poketinder.model.Pokemon
import net.iessochoa.sergiocontreras.poketinder.model.PokemonRepository
import net.iessochoa.sergiocontreras.poketinder.ui.components.PokemonCard

@Composable
fun EncuentrosScreen(onNavigateToCapturas: () -> Unit) {
    var currentPokemon by remember { mutableStateOf(PokemonRepository.getRandomPokemon()) }
    var pokeBalls by remember { mutableStateOf(5) }
    var huidas by remember { mutableStateOf(2) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (pokeBalls > 0 && huidas > 0) {
            PokemonCard(pokemon = currentPokemon)
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(onClick = { /* swipe izquierda */
                    if (huidas > 0) {
                        huidas--
                        currentPokemon = PokemonRepository.getRandomPokemon()
                    }
                }) {
                    Text(text = "Huir ($huidas)")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { /* swipe derecha */
                    if (pokeBalls > 0) {
                        pokeBalls--
                        // Aquí iría la lógica para capturar
                        currentPokemon = PokemonRepository.getRandomPokemon()
                    }
                }) {
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

