package it.to.peppesca.data.mappers

import it.to.peppesca.utils.POKEMON_DETAIL_RESPONSE_STUB
import it.to.peppesca.utils.POKEMON_LOCAL_STUB
import org.amshove.kluent.`should be equal to`
import org.junit.Test

/**
 * Test class for [PokemonDetailResponseToPokemonLocalMapperImpl].
 */
class PokemonDetailResponseToPokemonLocalMapperImplTest {

    private val target = PokemonDetailResponseToPokemonLocalMapperImpl()

    @Test
    fun `given a pokemon local, then return a pokemon entity`() {
        target.map(POKEMON_DETAIL_RESPONSE_STUB) `should be equal to` POKEMON_LOCAL_STUB
    }

}