package it.to.peppesca.pokemoninterview.injection

import it.to.peppesca.pokemoninterview.ui.list.PokemonListViewModel
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

// MyViewModel ViewModel
val viewModelModule = module {
    viewModel { PokemonListViewModel(get(),get()) }
    //viewModel { PokemonPagedViewModel(get(),get()) }

}

val presentationMapperModule = module {
    single<PokemonShortEntityToPokemonModelMapper> { PokemonShortEntityToPokemonModelMapperImpl() }
    single<PokemonEntityToPokemonModelMapper> { PokemonEntityToPokemonModelMapperImpl() }
}