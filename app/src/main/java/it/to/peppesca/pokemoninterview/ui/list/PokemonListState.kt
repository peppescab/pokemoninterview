package it.to.peppesca.pokemoninterview.ui.list

import androidx.paging.PagingData
import io.uniflow.core.flow.data.UIState
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel
import kotlinx.coroutines.flow.Flow

/**
 * State of this view
 */

sealed class PokemonListState : UIState() {
    object Loading : PokemonListState()
    data class PokemonList(val pokemons: Flow<PagingData<PokemonModel>>) : PokemonListState()
    data class Failed(val error: Exception) : PokemonListState()
}