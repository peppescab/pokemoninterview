package it.to.peppesca.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(PokemonLocal::class),version = 2)
abstract class AppDatabase :RoomDatabase(){
    abstract fun pokemonDao(): PokemonDao
}