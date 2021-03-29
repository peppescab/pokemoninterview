package it.to.peppesca.pokemoninterview.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import io.uniflow.android.livedata.onStates
import it.to.peppesca.pokemoninterview.databinding.FragmentPokemonListBinding
import it.to.peppesca.pokemoninterview.ui.base.BaseFragment
import it.to.peppesca.pokemoninterview.ui.list.adapter.PokemonsAdapter
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonState
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.viewmodel.ext.android.viewModel


class PokemonListFragment : BaseFragment<FragmentPokemonListBinding>() {

    val pokemonListViewmodel: PokemonListViewModel by viewModel()
   // val pokemonListViewmodelPaged: PokemonPagedViewModel by viewModel()

    private val pokemonAdapter = PokemonsAdapter {
        PokemonsAdapter {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBinding(FragmentPokemonListBinding.inflate(inflater, container, false))
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = pokemonListViewmodel

        binding.rvShips.adapter = pokemonAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemonListViewmodel.pokemonList.observe(viewLifecycleOwner, {
            when {
                it.isSuccessful -> pokemonAdapter.updateRecycler(it.content!!)
            }

        })

        // Observe incoming state
        onStates(pokemonListViewmodel) { state ->
            when (state) {
                // react on each updates
                is PokemonState.Loading -> handleLoading()
                is PokemonState.Failed -> handleError()
                is PokemonState.PokemonList -> {
                    pokemonAdapter.updateRecycler(state.pokemons)
                }
            }
        }
/*
        lifecycleScope.launchWhenCreated {
            pokemonListViewmodelPaged.posts.collectLatest {
                pokemonAdapter.submitData(it)
            }
        }*/

    }

    override fun onResume() {
        super.onResume()
         pokemonListViewmodel.fetchPokemons()

        //pokemonListViewmodelPaged.showSubreddit("")
    }

    private fun handleLoading() {
        view?.let {
            Snackbar.make(it, "Loading", Snackbar.LENGTH_LONG).show()
        }
    }

    private fun handleError() {
        view?.let {
            Snackbar.make(it, "Error occurred", Snackbar.LENGTH_LONG).show()
        }
    }


}