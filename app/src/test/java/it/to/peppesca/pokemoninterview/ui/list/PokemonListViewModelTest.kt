package it.to.peppesca.pokemoninterview.ui.list

import androidx.paging.PagingData
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.mockk
import io.uniflow.android.test.TestViewObserver
import io.uniflow.android.test.createTestObserver
import io.uniflow.core.logger.DebugMessageLogger
import io.uniflow.core.logger.UniFlowLogger
import it.to.peppesca.domain.models.PokemonDetailEntity
import it.to.peppesca.domain.usecase.GetPokemonListPagedUseCase
import it.to.peppesca.pokemoninterview.R
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonListState
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel
import it.to.peppesca.pokemoninterview.ui.list.model.mappers.PokemonDetailEntityToPokemonModelMapperImpl
import it.to.peppesca.pokemoninterview.utils.ViewModelTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

/**
 *  Test class for [PokemonListViewModel]
 */
class PokemonListViewModelTest : ViewModelTest() {

    private val getPokemonByIdUseCase: GetPokemonListPagedUseCase = mockk(relaxed = true)
    private val pokemonDetailEntityToPokemonModelMapper = PokemonDetailEntityToPokemonModelMapperImpl()
    private lateinit var target: PokemonListViewModel

    lateinit var tester: TestViewObserver

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        target = PokemonListViewModel(getPokemonByIdUseCase, pokemonDetailEntityToPokemonModelMapper)
        tester = target.createTestObserver()
        UniFlowLogger.init(DebugMessageLogger())
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `given a pokemon list, when is requested, then return a list`() {

        coEvery { getPokemonByIdUseCase.execute() } returns flow{POKEMON_PAGE}

        runBlockingTest {
            target.fetchPokemons()
        }

        tester.verifySequence(
            PokemonListState.Loading,
            PokemonListState.PokemonList(PagingData.from(POKEMON_MODEL_LISt))
        )

    }

    companion object {
        const val POKEMON_ID = 2
        val POKEMON_MODEL_LISt = listOf(PokemonModel(POKEMON_ID, "", "", listOf("fie", ""), 0, 0, 0, R.color.orange, R.drawable.ic_fire))
        val POKEMON_MODEL_ENT_LIST = listOf(PokemonDetailEntity(POKEMON_ID, "", "", listOf("fire", ""), 0, 0, 0))
        val POKEMON_PAGE = PagingData.from(POKEMON_MODEL_ENT_LIST)

    }

}