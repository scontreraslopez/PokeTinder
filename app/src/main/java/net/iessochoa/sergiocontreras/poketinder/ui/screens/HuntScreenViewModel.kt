package net.iessochoa.sergiocontreras.poketinder.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import net.iessochoa.sergiocontreras.poketinder.model.PokemonRepository

class HuntScreenViewModel: ViewModel() {

    private val startingPokemon = PokemonRepository.getRandomPokemon()
    private val pokemonRepository = PokemonRepository

    private val _uiState = MutableStateFlow(HuntScreenUiState(
        escapesLeft = 2,
        pokeballsLeft = 5,
        currentPokemon = startingPokemon,
        capturedPokemons = emptyList()
))

    val uistate: StateFlow<HuntScreenUiState> = _uiState.asStateFlow()

    fun swipeLeft() {

        _uiState.update { currentState ->
            if (currentState.escapesLeft > 0) {
                currentState.copy(
                    escapesLeft = currentState.escapesLeft - 1,
                    currentPokemon = pokemonRepository.getRandomPokemon()
                )
            } else {
                currentState
            }
        }



    }

    fun swipeRight() {

        //TODO: Falta añadir a pokemons capturados

        _uiState.update { currentState ->
            if (currentState.pokeballsLeft > 0) {
                currentState.copy(
                    pokeballsLeft = currentState.pokeballsLeft - 1,
                    currentPokemon = pokemonRepository.getRandomPokemon()
                )
            } else {
                currentState
            }
        }


    }


}