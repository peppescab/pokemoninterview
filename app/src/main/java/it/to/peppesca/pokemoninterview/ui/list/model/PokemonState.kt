package it.to.peppesca.pokemoninterview.ui.list.model

import io.uniflow.core.flow.data.UIState

/**
 * State of this view
 */

sealed class PokemonState : UIState() {
    object Loading : PokemonState()
    data class PokemonList(val pokemons: List<PokemonModel>) : PokemonState()
    data class Failed(val error: Exception) : PokemonState()
}