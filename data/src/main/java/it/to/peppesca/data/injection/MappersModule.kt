package it.to.peppesca.data.injection

import it.to.peppesca.data.mappers.*
import org.koin.dsl.module

/**
 * Module for the mappers in data and domain layer.
 */
val mappersModule = module {
    single<PokemonDetailResponseToPokemonLocalMapper> { PokemonDetailResponseToPokemonLocalMapperImpl() }
    single<PokemonLocalToPokemonEntityMapper> { PokemonLocalToPokemonEntityMapperImpl() }
    single<PokemonLocalToPokemonDetailEntityMapper> { PokemonLocalToPokemonDetailEntityMapperImpl() }
    single<PokemonResultToPokemonEntityMapper> { PokemonResultToPokemonEntityMapperImpl() }
    single<PokemonDetailResponseToPokemonDetailEntityMapper> { PokemonDetailResponseToPokemonDetailEntityMapperImpl() }
}