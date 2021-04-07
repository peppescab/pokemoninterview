package it.to.peppesca.pokemoninterview.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.google.android.material.snackbar.Snackbar
import io.uniflow.android.livedata.onStates
import it.to.peppesca.pokemoninterview.databinding.FragmentPokemonListBinding
import it.to.peppesca.pokemoninterview.ui.base.BaseFragment
import it.to.peppesca.pokemoninterview.ui.list.adapter.PokemonPagedAdapter
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonListState
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Fragment for showing a paged list of [PokemonModel].
 */
class PokemonListFragment : BaseFragment<FragmentPokemonListBinding>() {

    private val pokemonListViewmodel: PokemonListViewModel by viewModel()

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
        binding.viewModel = pokemonListViewmodel
        setupList()
        binding.swipeToRefresh.setOnRefreshListener { pokemonAdapter.retry() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonListViewmodel.fetchPokemons()

        pokemonListViewmodel.searchMediator.observe(viewLifecycleOwner, {
            handleResult(it)
        })

        // Observe incoming state
        onStates(pokemonListViewmodel) { state ->
            when (state) {
                // react on each updates
                is PokemonListState.Loading -> handleLoading()
                is PokemonListState.Failed -> handleError()
                is PokemonListState.PokemonList -> handleResult(state.pokemons)
            }
        }


    }

    private fun handleResult(pagindData: PagingData<PokemonModel>) {
        binding.swipeToRefresh.isRefreshing = false
        lifecycleScope.launch {
            //  pagindData.collectLatest {
            pokemonAdapter.submitData(pagindData)
            //}
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

    private fun setupList() {
        binding.rvPokemons.adapter = pokemonAdapter
        pokemonAdapter.addLoadStateListener { loadState ->
            /**
            This code is taken from https://medium.com/@yash786agg/jetpack-paging-3-0-android-bae37a56b92d
             **/
            if (loadState.refresh is LoadState.Loading) {
                handleLoading()
            } else {
                binding.swipeToRefresh.isRefreshing = false
            }
            if ((loadState.prepend is LoadState.Error
                        || loadState.append is LoadState.Error
                        || loadState.refresh is LoadState.Error)
            ) {
                handleError()
            }

        }
    }
}