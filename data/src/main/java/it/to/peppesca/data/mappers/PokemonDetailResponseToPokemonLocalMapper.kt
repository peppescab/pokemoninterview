package it.to.peppesca.data.mappers

import it.to.peppesca.data.dao.PokemonLocal
import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.detail.Type
import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonEntity

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonDetailResponseToPokemonLocalMapper :
    Mapper<PokemonDetailResponse, PokemonLocal>

class PokemonDetailResponseToPokemonLocalMapperImpl : PokemonDetailResponseToPokemonLocalMapper {

    override fun map(input: PokemonDetailResponse): PokemonLocal = with(input) {
        PokemonLocal(
            id = id,
            name = name,
            urlImage = sprites.frontDefault ?: "",
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