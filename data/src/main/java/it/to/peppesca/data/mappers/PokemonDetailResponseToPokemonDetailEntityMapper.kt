package it.to.peppesca.data.mappers

import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.detail.Type
import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.models.PokemonEntity

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonDetailResponseToPokemonDetailEntityMapper :
    Mapper<PokemonDetailResponse, PokemonDetailEntity>

class PokemonDetailResponseToPokemonDetailEntityMapperImpl :
    PokemonDetailResponseToPokemonDetailEntityMapper {

    override fun map(input: PokemonDetailResponse): PokemonDetailEntity = with(input) {
        PokemonDetailEntity(
            id = id,
            urlImage = sprites.frontDefault ?: "",
            name = name,
            type = typeToString(types),
            baseExp = baseExperience,
            height = height,
            weight = weight
        )
    }

    private fun typeToString(inputList: List<Type>): List<String> {
        val outputList = mutableListOf<String>()
        inputList.forEach { outputList.add(it.type?.name.orEmpty()) }
        return outputList
    }
}