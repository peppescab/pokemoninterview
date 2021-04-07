package it.to.peppesca.data.mappers

import it.to.peppesca.utils.POKEMON_ENTITY_STUB
import it.to.peppesca.utils.POKEMON_RESULT_STUB
import org.amshove.kluent.`should be equal to`
import org.junit.Test

/**
 * Test class for [PokemonResultToPokemonEntityMapperImpl].
 */
class PokemonResultToPokemonEntityMapperImplTest {

    private val target = PokemonResultToPokemonEntityMapperImpl()

    @Test
    fun `given a pokemon result, then return a pokemon entity`() {
        target.map(POKEMON_RESULT_STUB) `should be equal to` POKEMON_ENTITY_STUB
    }

}