package it.to.peppesca.data.mappers

import it.to.peppesca.utils.POKEMON_ENTITY_STUB
import it.to.peppesca.utils.POKEMON_LOCAL_STUB
import org.amshove.kluent.`should be equal to`
import org.junit.Test

/**
 * Test class for [PokemonLocalToPokemonEntityMapperImpl].
 */
class PokemonLocalToPokemonEntityMapperImplTest {

    private val target = PokemonLocalToPokemonEntityMapperImpl()

    @Test
    fun `given a pokemon local, then return a pokemon entity`() {
        target.map(POKEMON_LOCAL_STUB) `should be equal to` POKEMON_ENTITY_STUB
    }

}