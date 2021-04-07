package it.to.peppesca.data.datasource

import it.to.peppesca.data.dao.PokemonDao
import it.to.peppesca.data.dao.PokemonLocal
import it.to.peppesca.data.datasource.interfaces.PokemonLocalDataSource
import it.to.peppesca.domain.common.GeneralValues.SINGLE_PAGE_LIMIT

/**
 * This Datasource handle all the function to local database.
 */
class PokemonLocalDatasourceImpl(
    private val dao: PokemonDao
) : PokemonLocalDataSource {

    override suspend fun getPokemonList(): List<PokemonLocal> {
        return dao.getAll()
    }

    override suspend fun getSinglePokemon(pokemonId: Int): PokemonLocal? {
        return dao.getPokemonById(pokemonId)
    }

    override suspend fun getPokemonRanged(pokemonStart: Int): List<PokemonLocal> {
        return dao.getPokemonRange(pokemonStart, pokemonStart + SINGLE_PAGE_LIMIT)
    }

    override suspend fun insertPokemon(pokemonLocal: PokemonLocal) {
        dao.insert(pokemonLocal)
    }

}