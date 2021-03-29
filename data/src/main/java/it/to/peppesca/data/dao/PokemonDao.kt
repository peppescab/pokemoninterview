package it.to.peppesca.data.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM PokemonLocal")
    suspend fun getAll(): List<PokemonLocal>

    @Query("SELECT * FROM PokemonLocal")
    fun getPagedAll(): PagingSource<Int, PokemonLocal>

    @Query("SELECT * FROM PokemonLocal WHERE id=:pokemonId")
    fun getPokemonById(pokemonId: String): Flow<PokemonLocal>?

    @Insert
    suspend fun insert(pokemon: PokemonLocal)
}