package it.to.peppesca.data.injection

import it.to.peppesca.data.datasource.PokemonLocalDatasourceImpl
import it.to.peppesca.data.datasource.PokemonRemoteDatasourceImpl
import it.to.peppesca.data.datasource.interfaces.PokemonLocalDataSource
import it.to.peppesca.data.datasource.interfaces.PokemonRemoteDataSource
import org.koin.dsl.module

val datasourceModule = module {
    single<PokemonRemoteDataSource> { PokemonRemoteDatasourceImpl(get()) }
    single<PokemonLocalDataSource> { PokemonLocalDatasourceImpl(get()) }
}