package it.to.peppesca.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * This class represent DAO for accessing to database functions.
 */
@Dao
interface PokemonDao {

    @Query("SELECT * FROM PokemonLocal")
    suspend fun getAll(): List<PokemonLocal>

    @Query("SELECT * FROM PokemonLocal WHERE id=:pokemonId")
    suspend fun getPokemonById(pokemonId: Int): PokemonLocal?

    @Query("SELECT * FROM PokemonLocal WHERE id>:startingId AND id<=:endingId")
    suspend fun getPokemonRange(startingId: Int, endingId: Int): List<PokemonLocal>

    @Insert
    suspend fun insert(pokemon: PokemonLocal)

}