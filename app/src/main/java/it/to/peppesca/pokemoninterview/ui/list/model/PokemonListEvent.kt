package it.to.peppesca.pokemoninterview.ui.list.model

import io.uniflow.core.flow.data.UIEvent

/**
 *
 */
sealed class PokemonListEvent : UIEvent() {
    /**
     * Retrieves the list of pokemons.
     */
    object GetPokemonsEvent : PokemonListEvent()

    /**
     * Deletes a user
     *
     * @param pokemonId the id of the pokemon to be selected.
     */
    data class SelectPokemonrEvent(val pokemonId: Int) : PokemonListEvent()

    /**
     * Marks an error as managed.
     */
    object ErrorManagedEvent : PokemonListEvent()
}