package it.to.peppesca.data.datasource

import android.content.Context
import androidx.room.Room
import it.to.peppesca.data.dao.AppDatabase
import it.to.peppesca.data.dao.PokemonLocal
import it.to.peppesca.data.datasource.interfaces.PokemonLocalDataSource

/**
 *
 */
class PokemonLocalDatasourceImpl(
    context: Context
) : PokemonLocalDataSource {

    private val dao by lazy {
        Room.databaseBuilder(context, AppDatabase::class.java, "pokemonDB")
            .build()
            .pokemonDao()
    }

    override suspend fun getPokemonList(): List<PokemonLocal> {
        return dao.getAll()
    }

    override suspend fun getSinglePokemon(pokemonId: Long): PokemonLocal? {
        return dao.getPokemonById(pokemonId)
    }

    override suspend fun insertPokemon(pokemonLocal: PokemonLocal) {
        dao.insert(pokemonLocal)
    }

}