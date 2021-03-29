package it.to.peppesca.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PokemonLocal::class),version = 1)
abstract class AppDatabase :RoomDatabase(){
    abstract fun pokemonDao(): PokemonDao
}