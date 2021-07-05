package it.to.peppesca.pokemoninterview.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import it.to.peppesca.pokemoninterview.R
import it.to.peppesca.pokemoninterview.databinding.ItemPokemonBinding
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel

class PokemonPagedAdapter(
    private val callback: OnItemSelected<PokemonModel>
) : PagingDataAdapter<PokemonModel, PokemonPagedAdapter.ViewHolder>(
    PokemonModelComparator
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_pokemon, parent, false
            )
        )
    }

    inner class ViewHolder(var binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                binding.pokemonItem?.let {
                    callback.onItemSelected(it)
                }
            }
        }

        fun setPokemonModel(pokemon: PokemonModel) {
            binding.pokemonItem = pokemon
        }
    }

    companion object {
        private val PokemonModelComparator = object : DiffUtil.ItemCallback<PokemonModel>() {

            override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean =
                oldItem == newItem

        }
    }

    override fun onBindViewHolder(holder: PokemonPagedAdapter.ViewHolder, position: Int) {
        val pokemonSingle = getItem(position)
        pokemonSingle?.let{
            holder.setPokemonModel(it)
        }

    }

}