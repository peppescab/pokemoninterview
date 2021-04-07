package it.to.peppesca.domain.models

/**
 * This class keeps info about the present page and the list of pokemons.
 *
 * @param pokemons is the list of pokemons
 * @param page present page
 */
data class PokemonsPagedEntity(val pokemons: List<PokemonDetailEntity>, val page: Int)