package it.to.peppesca.pokemoninterview.ui.detail.model

import io.uniflow.core.flow.data.UIState
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel

/**
 * State of this view
 */

sealed class PokemonDetailState : UIState() {
    object Loading : PokemonDetailState()
    data class Success(val pokemon: PokemonModel) : PokemonDetailState()
    data class Failed(val error: Exception) : PokemonDetailState()
}