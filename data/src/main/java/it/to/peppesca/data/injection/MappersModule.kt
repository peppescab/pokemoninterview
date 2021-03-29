package it.to.peppesca.data.injection

import it.to.peppesca.data.mappers.*
import org.koin.dsl.module

val mappersModule = module {
    single<ResultToPokemonEntityMapper> { ResultToPokemonEntityMapperImpl() }
    single<PokemonDetailResponseToPokemonEntityMapper> { PokemonDetailResponseToPokemonEntityMapperImpl() }
    single<PokemonDetailResponseToPokemonLocalMapper> { PokemonDetailResponseToPokemonLocalMapperImpl() }
    single<PokemonLocalToPokemonShortEntityMapper> { PokemonLocalToPokemonShortEntityMapperImpl() }
    single<PokemonResultToPokemonEntityMapper> { PokemonResultToPokemonEntityMapperImpl() }
}