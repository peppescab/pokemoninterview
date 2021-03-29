package it.to.peppesca.pokemoninterview.ui.list

import io.uniflow.core.flow.data.UIState
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel

/**
 * State of this view
 */

sealed class PokemonListState : UIState() {
    object Loading : PokemonListState()
    data class PokemonList(val pokemons: List<PokemonModel>) : PokemonListState()
    data class Failed(val error: Exception) : PokemonListState()
}