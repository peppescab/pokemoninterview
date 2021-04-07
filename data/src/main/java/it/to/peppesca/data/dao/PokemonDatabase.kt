package it.to.peppesca.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * AppDatabase starting point for PokemonDao.
 */
@Database(entities = [PokemonLocal::class], version = 1)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao

    companion object {
        @Volatile
        private var instance: PokemonDatabase? = null

        fun getInstance(context: Context): PokemonDatabase {
            if (instance == null) {
                synchronized(this) {
                    instance = Room.databaseBuilder(context.applicationContext, PokemonDatabase::class.java, "pokemons.db").build()
                }
            }
            return instance!!
        }
    }
}