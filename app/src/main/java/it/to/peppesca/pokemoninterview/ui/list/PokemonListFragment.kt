package it.to.peppesca.pokemoninterview.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingData
import com.google.android.material.snackbar.Snackbar
import io.uniflow.android.livedata.onStates
import it.to.peppesca.pokemoninterview.databinding.FragmentPokemonListBinding
import it.to.peppesca.pokemoninterview.ui.base.BaseFragment
import it.to.peppesca.pokemoninterview.ui.list.adapter.PokemonPagedAdapter
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel


class PokemonListFragment : BaseFragment<FragmentPokemonListBinding>() {

    val pokemonListViewmodelPaged: PokemonPagedListViewModel by viewModel()

    private val pokemonAdapter = PokemonPagedAdapter { pokemonModel ->
        findNavController().navigate(
            PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailFragment(
                pokemonModel.id
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBinding(FragmentPokemonListBinding.inflate(inflater, container, false))
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = pokemonListViewmodelPaged
        binding.rvPokemons.adapter = pokemonAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonListViewmodelPaged.fetchPokemons()

        // Observe incoming state
        onStates(pokemonListViewmodelPaged) { state ->
            when (state) {
                // react on each updates
                is PokemonListState.Loading -> handleLoading()
                is PokemonListState.Failed -> handleError()
                is PokemonListState.PokemonList -> handleResult(state.pokemons)
            }
        }
    }

    private fun handleResult(pagindData: Flow<PagingData<PokemonModel>>) {
        binding.swipeToRefresh.isRefreshing = false
        lifecycleScope.launch {
            pagindData.distinctUntilChanged().collectLatest {
                pokemonAdapter.submitData(it)
            }
        }
    }

    private fun handleLoading() {
        view?.let {
            binding.swipeToRefresh.isRefreshing = true
        }
    }

    private fun handleError() {
        view?.let {
            binding.swipeToRefresh.isRefreshing = false
            Snackbar.make(it, "Error occurred", Snackbar.LENGTH_LONG).show()
        }
    }


}