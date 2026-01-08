package net.iessochoa.sergiocontreras.poketinder.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import net.iessochoa.sergiocontreras.poketinder.model.PokemonRepository

class CapturesScreenViewModel: ViewModel() {

    private val startingPokemon = PokemonRepository.getRandomPokemon()

    private val _uiState = MutableStateFlow(CapturesScreenUiState(
        escapesLeft = 2,
        pokeballsLeft = 5,
        currentPokemon = startingPokemon,
        capturedPokemons = emptyList()
))

    val uistate: StateFlow<CapturesScreenUiState> = _uiState.asStateFlow()


}