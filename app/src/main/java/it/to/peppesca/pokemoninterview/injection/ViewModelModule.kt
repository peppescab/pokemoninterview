package it.to.peppesca.pokemoninterview.injection

import it.to.peppesca.pokemoninterview.ui.detail.PokemonDetailViewModel
import it.to.peppesca.pokemoninterview.ui.list.PokemonListViewModel
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.PokemonDetailEntityToPokemonModelMapper
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.PokemonDetailEntityToPokemonModelMapperImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PokemonListViewModel(get(),get()) }
    viewModel { PokemonDetailViewModel(get(), get()) }
}

val presentationMapperModule = module {
    single<PokemonDetailEntityToPokemonModelMapper> { PokemonDetailEntityToPokemonModelMapperImpl() }
}