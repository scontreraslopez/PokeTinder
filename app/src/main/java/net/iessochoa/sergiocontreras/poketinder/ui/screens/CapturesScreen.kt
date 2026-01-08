package net.iessochoa.sergiocontreras.poketinder.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.iessochoa.sergiocontreras.poketinder.model.Pokemon
import net.iessochoa.sergiocontreras.poketinder.model.PokemonRepository
import net.iessochoa.sergiocontreras.poketinder.ui.components.PokemonCard

@Composable
fun CapturesScreen(
    capturedPokemon: List<Pokemon>, onBack: () -> Unit)
{



    //Vamos a inventarnos unos captures pokemons para no mostrarlo vacio, ya lo cambiaremos
    // Metemos 3 random pokemons
    val capturedPokemon = listOf(
        PokemonRepository.getRandomPokemon(),
        PokemonRepository.getRandomPokemon(),
        PokemonRepository.getRandomPokemon()
    )


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onBack) {
            Text(text = "Volver")
        }
        LazyColumn {
            items(capturedPokemon) {
                PokemonCard(pokemon = it)
            }
        }
    }
}