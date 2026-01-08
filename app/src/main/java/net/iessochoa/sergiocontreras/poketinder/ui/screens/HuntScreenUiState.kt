package net.iessochoa.sergiocontreras.poketinder.ui.screens

import net.iessochoa.sergiocontreras.poketinder.model.Pokemon

data class HuntScreenUiState (
    val escapesLeft: Int,
    val pokeballsLeft: Int,
    val currentPokemon: Pokemon,
    val capturedPokemons: List<Pokemon>
)