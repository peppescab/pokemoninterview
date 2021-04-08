package it.to.peppesca.pokemoninterview.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.uniflow.test.rule.UniflowTestDispatchersRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

/**
 * Base for implementing ViewModel's test.
 */
open class ViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val testDispatcherRule = UniflowTestDispatchersRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

}