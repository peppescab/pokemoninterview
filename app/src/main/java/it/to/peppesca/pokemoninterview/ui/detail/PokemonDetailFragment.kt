package it.to.peppesca.pokemoninterview.ui.detail

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import io.uniflow.android.livedata.onStates
import it.to.peppesca.pokemoninterview.R
import it.to.peppesca.pokemoninterview.databinding.FragmentPokemonDetailBinding
import it.to.peppesca.pokemoninterview.ui.base.BaseFragment
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel
import org.koin.android.viewmodel.ext.android.viewModel

class PokemonDetailFragment : BaseFragment<FragmentPokemonDetailBinding>() {

    private val args: PokemonDetailFragmentArgs by navArgs()
    val viewmodel: PokemonDetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBinding(FragmentPokemonDetailBinding.inflate(inflater, container, false))
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.getAPokemonById(args.pokemonId)

        // Observe incoming state
        onStates(viewmodel) { state ->
            when (state) {
                // react on each updates
                is PokemonDetailState.Loading -> handleLoading()
                is PokemonDetailState.Failed -> handleError()
                is PokemonDetailState.Success -> fillPokemon(state.pokemon)
            }
        }

    }

    private fun handleLoading() {
        view?.let {

        }
    }

    private fun handleError() {
        view?.let {
            Snackbar.make(it, getString(R.string.generic_error), Snackbar.LENGTH_LONG).show()
        }
    }

    private fun fillPokemon(pokemonModel: PokemonModel) {
        binding.pokemonModel = pokemonModel
        binding.ivType.setColorFilter(
            ContextCompat.getColor(
                requireContext(),
                pokemonModel.colorResource
            ), PorterDuff.Mode.SRC_ATOP
        )
        binding.ivType.setImageResource(pokemonModel.iconResource)
    }

}