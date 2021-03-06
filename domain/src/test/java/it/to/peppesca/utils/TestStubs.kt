package it.to.peppesca.utils

import androidx.paging.PagingData
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.models.PokemonEntity
import it.to.peppesca.domain.models.PokemonsPagedEntity

val POKEMON_ID_STUB = 2
val POKEMON_NAME_STUB = "ivysaur"
val POKEMON_TYPE_STRING_STUB = "grass"

val POKEMON_STARTING_ID = 3
val POKEMON_ENDING_ID = 23
val POKEMON_STARTING_INDEX = 0


val POKEMON_DETAIL_ENTITY_STUB = PokemonDetailEntity(POKEMON_ID_STUB, "ivysaur", "", listOf(POKEMON_TYPE_STRING_STUB), 30, 100, 300)
val POKEMON_DETAIL_ENTITY_STUB_1 = PokemonDetailEntity(3, "bulbasaur", "", listOf(POKEMON_TYPE_STRING_STUB), 35, 160, 320)
val POKEMON_DETAIL_ENTITY_STUB_2 = PokemonDetailEntity(4, "charmaleon", "", listOf(POKEMON_TYPE_STRING_STUB), 40, 105, 30)

val POKEMON_ENTITY_STUB = PokemonEntity(POKEMON_ID_STUB, "ivysaur")
val POKEMON_VENU_ENTITY_STUB = PokemonEntity(3, "venusaur")
val POKEMON_CHAR_ENTITY_STUB = PokemonEntity(4, "charmander")

val LIST_POKEMON_ENTITY = listOf(POKEMON_ENTITY_STUB,POKEMON_VENU_ENTITY_STUB,POKEMON_CHAR_ENTITY_STUB)
val LIST_POKEMON_ENTITY_RANGE = listOf(POKEMON_ENTITY_STUB, POKEMON_VENU_ENTITY_STUB, POKEMON_CHAR_ENTITY_STUB)
val LIST_POKEMON_DETAIL_ENTITY = listOf(POKEMON_DETAIL_ENTITY_STUB,POKEMON_DETAIL_ENTITY_STUB_1,POKEMON_DETAIL_ENTITY_STUB_2)

val POKEMON_PAGED_ENTITY_STUB = PokemonsPagedEntity(LIST_POKEMON_DETAIL_ENTITY, 3)

val POKEMON_FLOW_PAGED_POKEMON = PagingData.from(listOf(POKEMON_DETAIL_ENTITY_STUB))

val POKEMON_EXCEPTION = Throwable()
