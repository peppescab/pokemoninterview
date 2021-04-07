package it.to.peppesca.data.injection

import it.to.peppesca.data.datasource.PokemonLocalDatasourceImpl
import it.to.peppesca.data.datasource.PokemonRemoteDatasourceImpl
import it.to.peppesca.data.datasource.interfaces.PokemonLocalDataSource
import it.to.peppesca.data.datasource.interfaces.PokemonRemoteDataSource
import it.to.peppesca.data.repository.PokemonRepositoryImpl
import it.to.peppesca.domain.repositories.PokemonRepository
import it.to.peppesca.domain.usecase.GetPokemonByIdUseCase
import it.to.peppesca.domain.usecase.GetPokemonListPagedUseCase
import it.to.peppesca.domain.usecase.GetPokemonListUseCase
import org.koin.dsl.module


/**
 * Here are the module regarding Usecase Repositories and Datasources
 */
val useCaseModule = module {
    factory { GetPokemonListUseCase(get()) }
    factory { GetPokemonByIdUseCase(get()) }
    factory { GetPokemonListPagedUseCase(get()) }
}


val repositoryModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get(), get(),get(),get(),get(),get(),get()) }
}

val datasourceModule = module {
    single<PokemonRemoteDataSource> { PokemonRemoteDatasourceImpl(get()) }
    single<PokemonLocalDataSource> { PokemonLocalDatasourceImpl(get()) }
}