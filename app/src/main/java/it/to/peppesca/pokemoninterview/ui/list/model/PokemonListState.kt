package it.to.peppesca.pokemoninterview.ui.list.model

import androidx.paging.PagingData
import io.uniflow.core.flow.data.UIState

/**
 * State of this view
 */

sealed class PokemonListState : UIState() {
    object Loading : PokemonListState()
    data class PokemonList(val pokemons: PagingData<PokemonModel>) : PokemonListState()
    data class Failed(val error: Exception) : PokemonListState()
}