package it.to.peppesca.data.repository

import it.to.peppesca.data.datasource.interfaces.PokemonLocalDataSource
import it.to.peppesca.data.datasource.interfaces.PokemonRemoteDataSource
import it.to.peppesca.data.mappers.*
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonDetailEntity
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


    override suspend fun fecthPokemons(): List<PokemonEntity> {
        val pokemoIdsList = pokemonLocalDataSource.getPokemonList()

        return if (pokemoIdsList.isEmpty()) {
            resultToPokemonEntityMapper.map(pokemonRemoteDataSource.getPokemonList().results)
        } else {
            pokemonLocalToPokemonEntityMapper.map(pokemoIdsList)
        }
    }

    override suspend fun catchPokemon(pokemonId: Long): PokemonDetailEntity {

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
/*
    override suspend fun getPagedPokemons(pageSize: Int): PagingData<PokemonEntity>
        = Pager(PagingConfig(pageSize)) { pokemonRemoteDataSource.getPagedPokemons(pageSize) }
*/


}