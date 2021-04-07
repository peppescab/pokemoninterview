package it.to.peppesca.data.injection

import androidx.room.Room
import it.to.peppesca.data.dao.PokemonDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Dependecies for Database.
 */
val databaseModule = module {
    single { Room.databaseBuilder(androidApplication(), PokemonDatabase::class.java, "pokemons.db").build() }
    single { get<PokemonDatabase>().pokemonDao() }
}