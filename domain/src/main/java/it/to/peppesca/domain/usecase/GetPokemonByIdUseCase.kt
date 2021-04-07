package it.to.peppesca.domain.usecase

import android.content.res.Resources
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.repositories.PokemonRepository
import it.to.peppesca.domain.usecase.base.ActionResultUseCase
import kotlin.jvm.Throws

/**
 *
 */
class GetPokemonByIdUseCase(private val pokemonRepository: PokemonRepository) :
    ActionResultUseCase<Int, PokemonDetailEntity> {

    @Throws (Resources.NotFoundException::class)
    override suspend fun execute(pokemonId: Int): PokemonDetailEntity {

        return pokemonRepository.catchPokemon(pokemonId)

    }
}