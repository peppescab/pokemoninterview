package it.to.peppesca.utils

import it.to.peppesca.data.dao.PokemonLocal
import it.to.peppesca.data.dto.detail.PokemonDetailResponse
import it.to.peppesca.data.dto.detail.Sprites
import it.to.peppesca.data.dto.detail.Type
import it.to.peppesca.data.dto.detail.TypeX
import it.to.peppesca.data.dto.list.PokemonResult
import it.to.peppesca.data.dto.list.PokemonsResponse
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.models.PokemonEntity

val POKEMON_ID_STUB = 2
val POKEMON_NAME_STUB = "ivysaur"
val POKEMON_TYPE_STRING_STUB = "grass"
val POKEMON_TYPE_STUB = Type(2, TypeX(POKEMON_TYPE_STRING_STUB, ""))

val POKEMON_STARTING_ID = 3
val POKEMON_ENDING_ID = 23


val POKEMON_RESULT_STUB = PokemonResult("ivysaur", "https://pokeapi.co/api/v2/pokemon/2/")

val POKEMON_RESPONSE_STUB = PokemonsResponse(11108, "12", "12", listOf(POKEMON_RESULT_STUB))

val POKEMON_RESPONSE_STUB_EMPTY = PokemonsResponse(11108, "12", "12", emptyList())

val POKEMON_DETAIL_RESPONSE_STUB = PokemonDetailResponse(
    30, 100, POKEMON_ID_STUB, false, "", POKEMON_NAME_STUB, 0,
    Sprites("", ""), listOf(POKEMON_TYPE_STUB), 300
)

val POKEMON_DETAIL_ENTITY_STUB = PokemonDetailEntity(POKEMON_ID_STUB, "ivysaur", "", listOf(POKEMON_TYPE_STRING_STUB), 30, 100, 300)


val POKEMON_LOCAL_STUB = PokemonLocal(2, POKEMON_NAME_STUB, "", listOf(POKEMON_TYPE_STRING_STUB), 30, 100, 300)
val POKEMON_VENU_LOCAL_STUB = PokemonLocal(3, "venusaur", "", listOf(POKEMON_TYPE_STRING_STUB), 30, 100, 300)
val POKEMON_CHAR_LOCAL_STUB = PokemonLocal(4, "charmander", "", listOf(POKEMON_TYPE_STRING_STUB), 30, 100, 300)

val POKEMON_ENTITY_STUB = PokemonEntity(POKEMON_ID_STUB, "ivysaur")
val POKEMON_VENU_ENTITY_STUB = PokemonEntity(3, "venusaur")
val POKEMON_CHAR_ENTITY_STUB = PokemonEntity(4, "charmander")


val LIST_POKEMON_LOCAL = listOf(POKEMON_LOCAL_STUB, POKEMON_VENU_LOCAL_STUB, POKEMON_CHAR_LOCAL_STUB)
val LIST_IN_RANGE_POKEMON_LOCAL = listOf(POKEMON_VENU_LOCAL_STUB, POKEMON_CHAR_LOCAL_STUB)

val LIST_POKEMON_ENTITY = listOf(POKEMON_ENTITY_STUB)
val LIST_POKEMON_ENTITY_RANGE = listOf(POKEMON_ENTITY_STUB, POKEMON_VENU_ENTITY_STUB, POKEMON_CHAR_ENTITY_STUB)