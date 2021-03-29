package it.to.peppesca.pokemoninterview.injection

import it.to.peppesca.data.injection.*

/**
 * In this class are kept all other koin references for dependecy injection
 */
val appModules =
    listOf(
        serviceModule,
        datasourceModule,
        mappersModule,
        repositoryModule,
        useCaseModule,
        viewModelModule,
        presentationMapperModule
    )




