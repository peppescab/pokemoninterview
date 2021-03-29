package it.to.peppesca.pokemoninterview.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import it.to.peppesca.pokemoninterview.databinding.FragmentPokemonDetailBinding
import it.to.peppesca.pokemoninterview.ui.base.BaseFragment

class PokemonDetailFragment : BaseFragment<FragmentPokemonDetailBinding>() {
    private val args: PokemonDetailFragmentArgs by navArgs()

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
        var pokemonModel = args.pokemon
        binding.tvName.text = pokemonModel.name
    }

}