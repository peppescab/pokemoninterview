package it.to.peppesca.data.repository

import it.to.peppesca.data.datasource.interfaces.PokemonLocalDataSource
import it.to.peppesca.data.datasource.interfaces.PokemonRemoteDataSource
import it.to.peppesca.data.mappers.*
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.repositories.PokemonRepository

class PokemonRepositoryImpl(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource,
    private val pokemonLocalDataSource: PokemonLocalDataSource,
    private val resultToPokemonEntityMapper: PokemonResultToPokemonEntityMapper,
    private val pokemonLocalToPokemonDetailEntityMapper: PokemonLocalToPokemonDetailEntityMapper,
    private val pokemonEntityToPokemonLocalMapper: PokemonDetailResponseToPokemonLocalMapper,
    private val pokemonLocalToPokemonEntityMapper: PokemonLocalToPokemonEntityMapper,
    private val pokemonDetailResponseToPokemonDetailEntityMapper: PokemonDetailResponseToPokemonDetailEntityMapper
) : PokemonRepository {
    /**
     * Search in database first if not found search in network
     */
    override suspend fun fetchPokemons(offset: Int): List<PokemonEntity> {

        val pokemonsLocal = pokemonLocalDataSource.getPokemonRanged(offset)
        return if (pokemonsLocal.isEmpty()) {
            return resultToPokemonEntityMapper.map(pokemonRemoteDataSource.getPokemonList(offset = offset).results)
        } else {
            pokemonLocalToPokemonEntityMapper.map(pokemonsLocal)
        }
    }

    /**
     * Get a pokemon by id if is found in local db it returns it
     * otherwise search in network and save the result in local.
     *
     * @param pokemonId the id of pokemon to be retrieved.
     */
    override suspend fun catchPokemon(pokemonId: Int): PokemonDetailEntity {

        pokemonLocalDataSource.getSinglePokemon(pokemonId)?.let {
            return pokemonLocalToPokemonDetailEntityMapper.map(it)
        } ?: run {
            val remotePokemon = pokemonRemoteDataSource.getSinglePokemon(pokemonId)
            val pokemonShort =
                pokemonDetailResponseToPokemonDetailEntityMapper.map(remotePokemon)
            pokemonLocalDataSource.insertPokemon(pokemonEntityToPokemonLocalMapper.map(remotePokemon))
            return pokemonShort
        }
    }
}