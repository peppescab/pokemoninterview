package it.to.peppesca.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * AppDatabase starting point for PokemonDao.
 */
@Database(entities = [PokemonLocal::class], version = 1)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}