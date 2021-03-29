package it.to.peppesca.data.repository

import android.content.Context
import androidx.room.Room
import it.to.peppesca.data.dao.AppDatabase
import it.to.peppesca.data.datasource.interfaces.PokemonRemoteDataSource
import it.to.peppesca.data.mappers.PokemonDetailResponseToPokemonEntityMapper
import it.to.peppesca.data.mappers.ResultToPokemonEntityMapper
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonShortDetailEntity
import it.to.peppesca.domain.repositories.PokemonRepository

class PokemonRepositoryImpl(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource,
    private val resultToPokemonEntityMapper: ResultToPokemonEntityMapper,
    private val pokemonDetailResponseToPokemonEntityMapper: PokemonDetailResponseToPokemonEntityMapper,
    context: Context
) : PokemonRepository {

    private val dao by lazy {
        Room.databaseBuilder(context, AppDatabase::class.java, "pokemonDB")
            .build()
            .pokemonDao()
    }

    override suspend fun fecthPokemons(): List<PokemonEntity> {
        return resultToPokemonEntityMapper.map(pokemonRemoteDataSource.getPokemonList().results)
    }

    override suspend fun catchPokemon(pokemonName: String): PokemonShortDetailEntity {
/*
        dao.getPokemonById(pokemonName)?.let {
            return flow {
                pokemonLocalToPokemonShortEntityMapper.map(it.first())
            }
        } ?: run {
*/
        val remotePokemon = pokemonRemoteDataSource.getSinglePokemon(pokemonName)
        val pokemonShort = pokemonDetailResponseToPokemonEntityMapper.map(remotePokemon)
        /*   dao.insert(pokemonLocalMapper.map(remotePokemon))
          return flow { pokemonShort }
       }*/

        return pokemonShort


    }
/*
    override suspend fun getPagedPokemons(pageSize: Int): PagingData<PokemonEntity>
        = Pager(PagingConfig(pageSize)) { pokemonRemoteDataSource.getPagedPokemons(pageSize) }
*/


}