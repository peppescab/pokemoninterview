package it.to.peppesca.pokemoninterview.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import io.uniflow.android.livedata.onStates
import it.to.peppesca.pokemoninterview.databinding.FragmentPokemonListBinding
import it.to.peppesca.pokemoninterview.ui.base.BaseFragment
import it.to.peppesca.pokemoninterview.ui.list.adapter.PokemonsAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class PokemonListFragment : BaseFragment<FragmentPokemonListBinding>() {

    val pokemonListViewmodel: PokemonListViewModel by viewModel()
    // val pokemonListViewmodelPaged: PokemonPagedViewModel by viewModel()

    private val pokemonAdapter = PokemonsAdapter { pokemonModel ->
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
        binding.rvPokemons.adapter = pokemonAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonListViewmodel.fetchPokemons()
        pokemonListViewmodel.pokemonList.observe(viewLifecycleOwner, {
            when {
                it.isSuccessful -> pokemonAdapter.updateRecycler(it.content!!)
            }

        })

        // Observe incoming state
        onStates(pokemonListViewmodel) { state ->
            when (state) {
                // react on each updates
                is PokemonListState.Loading -> handleLoading()
                is PokemonListState.Failed -> handleError()
                is PokemonListState.PokemonList -> {
                    binding.swipeToRefresh.isRefreshing = false
                    pokemonAdapter.updateRecycler(state.pokemons)
                }
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