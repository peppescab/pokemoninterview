package it.to.peppesca.data.mappers

import it.to.peppesca.utils.POKEMON_DETAIL_ENTITY_STUB
import it.to.peppesca.utils.POKEMON_LOCAL_STUB
import org.amshove.kluent.`should be equal to`
import org.junit.Test

/**
 * Test class for [PokemonLocalToPokemonDetailEntityMapperImpl].
 */
class PokemonLocalToPokemonDetailEntityMapperImplTest {

    private val target = PokemonLocalToPokemonDetailEntityMapperImpl()

    @Test
    fun `given a pokemon local, then return a pokemon entity`() {
        target.map(POKEMON_LOCAL_STUB) `should be equal to` POKEMON_DETAIL_ENTITY_STUB
    }

}