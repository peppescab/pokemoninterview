package it.to.peppesca.pokemoninterview.ui.list.model.mappers

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.domain.Mapper
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.pokemoninterview.R
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel
import java.util.*

/**
 * Maps a [PokemonResult] to a subset of [PokemonEntity]s
 */
interface PokemonDetailEntityToPokemonModelMapper :
    Mapper<PokemonDetailEntity, PokemonModel>

class PokemonDetailEntityToPokemonModelMapperImpl : PokemonDetailEntityToPokemonModelMapper {

    override fun map(input: PokemonDetailEntity): PokemonModel = with(input) {
        PokemonModel(
            id = id,
            name = name.capitalize(Locale.ROOT),
            urlImage = urlImage,
            baseExp = baseExp,
            type = type,
            height = height,
            weight = weight,
            colorResource = colorMapping(type[0]),
            iconResource = iconMapping(type[0])
        )
    }

    /**
     * function to map colors
     */
    @ColorRes
    private fun colorMapping(type: String): Int {
        return when (type) {

            "bug" -> R.color.dark_green
            "dark" -> R.color.black
            "dragon" -> R.color.azul
            "electric" -> R.color.light_yellow
            "fairy" -> R.color.fuchsia
            "fighting" -> R.color.red
            "fire" -> R.color.orange
            "flying" -> R.color.light_blue
            "ghost" -> R.color.purple_500
            "grass" -> R.color.green
            "ground" -> R.color.dark_orange
            "ice" -> R.color.light_green
            "normal" -> R.color.light_pink
            "poison" -> R.color.light_purple
            "psychic" -> R.color.lighter_pink
            "rock" -> R.color.lighter_yellow
            "steel" -> R.color.blue_green
            "water" -> R.color.dark_blue
            else -> R.color.light_grey
        }
    }

    /**
     * This function maps a type into a resource
     */
    @DrawableRes
    private fun iconMapping(type: String): Int {
        return when (type) {
            "bug" -> R.drawable.ic_bug
            "dark" -> R.drawable.ic_dark
            "dragon" -> R.drawable.ic_dragon
            "electric" -> R.drawable.ic_electric
            "fairy" -> R.drawable.ic_fairy
            "fighting" -> R.drawable.ic_fighting
            "fire" -> R.drawable.ic_fire
            "flying" -> R.drawable.ic_flying
            "ghost" -> R.drawable.ic_ghost
            "grass" -> R.drawable.ic_grass
            "ground" -> R.drawable.ic_ground
            "ice" -> R.drawable.ic_ice
            "normal" -> R.drawable.ic_normal
            "poison" -> R.drawable.ic_poison
            "psychic" -> R.drawable.ic_psychic
            "rock" -> R.drawable.ic_rock
            "steel" -> R.drawable.ic_steel
            "water" -> R.drawable.ic_water
            else -> R.color.light_grey
        }
    }
}