package it.to.peppesca.pokemoninterview.ui.detail

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import io.uniflow.android.test.TestViewObserver
import io.uniflow.android.test.createTestObserver
import io.uniflow.core.logger.DebugMessageLogger
import io.uniflow.core.logger.UniFlowLogger
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.usecase.GetPokemonByIdUseCase
import it.to.peppesca.pokemoninterview.R
import it.to.peppesca.pokemoninterview.ui.detail.model.PokemonDetailState
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.PokemonDetailEntityToPokemonModelMapperImpl
import it.to.peppesca.pokemoninterview.utils.ViewModelTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

/**
 * Test case for [PokemonDetailViewModel]
 */
@ExperimentalCoroutinesApi
class PokemonDetailViewModelTest : ViewModelTest() {


    private val getPokemonByIdUseCase: GetPokemonByIdUseCase = mockk(relaxed = true)
    private val pokemonDetailEntityToPokemonModelMapper = PokemonDetailEntityToPokemonModelMapperImpl()
    private lateinit var target: PokemonDetailViewModel

    lateinit var tester: TestViewObserver

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        target = PokemonDetailViewModel(getPokemonByIdUseCase, pokemonDetailEntityToPokemonModelMapper)
        tester = target.createTestObserver()
        UniFlowLogger.init(DebugMessageLogger())
    }

    @Test
    fun `given a pokemon, when is requested, then return a pokemon`() {

        coEvery { getPokemonByIdUseCase.execute(POKEMON_ID) } returns POKEMON_MODELENT

        runBlockingTest {
            target.getAPokemonById(POKEMON_ID)
        }

        tester.verifySequence(
            PokemonDetailState.Loading,
            PokemonDetailState.Success(POKEMON_MODEL)
        )

    }

    companion object {
        const val POKEMON_ID = 2
        val POKEMON_MODEL = PokemonModel(POKEMON_ID, "", "", listOf("fire", ""), 0, 0, 0, R.color.orange, R.drawable.ic_fire)
        val POKEMON_MODELENT = PokemonDetailEntity(POKEMON_ID, "", "", listOf("fire", ""), 0, 0, 0)
    }


}