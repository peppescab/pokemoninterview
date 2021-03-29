package it.to.peppesca.data.injection

import it.to.peppesca.data.repository.PokemonRepositoryImpl
import it.to.peppesca.domain.repositories.PokemonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get(), get(),get(),get()) }
}