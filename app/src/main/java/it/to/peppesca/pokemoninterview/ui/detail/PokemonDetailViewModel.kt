package it.to.peppesca.pokemoninterview.ui.detail

import io.uniflow.android.AndroidDataFlow
import it.to.peppesca.domain.usecase.GetPokemonByIdUseCase
import it.to.peppesca.pokemoninterview.ui.detail.model.PokemonDetailState
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.PokemonDetailEntityToPokemonModelMapper

/**
 * Viewmodel for the view [PokemonDetailFragment]
 */
class PokemonDetailViewModel(
    private val getPokemonByIdUseCase: GetPokemonByIdUseCase,
    private val pokemonDetailEntityToPokemonModelMapper: PokemonDetailEntityToPokemonModelMapper
) : AndroidDataFlow() {

    fun getAPokemonById(pokemonId: Int) = action(
        onAction = {
            setState(PokemonDetailState.Loading)
            val pokemoList =
                pokemonDetailEntityToPokemonModelMapper.map(getPokemonByIdUseCase.execute(pokemonId))
            setState(PokemonDetailState.Success(pokemoList))
        }, onError = { ex, _ ->
            setState(PokemonDetailState.Failed(ex))
        }
    )

}