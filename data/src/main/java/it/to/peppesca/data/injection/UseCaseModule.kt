package it.to.peppesca.data.injection

import it.to.peppesca.domain.usecase.GetPokemonByIdUseCase
import it.to.peppesca.domain.usecase.GetPokemonListUseCase
import org.koin.dsl.module

/**
 * Module declaration for all the use cases
 */
val useCaseModule = module {
    factory { GetPokemonListUseCase(get()) }
    factory { GetPokemonByIdUseCase(get()) }
}

