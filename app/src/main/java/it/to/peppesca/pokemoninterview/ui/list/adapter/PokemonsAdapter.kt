package it.to.peppesca.pokemoninterview.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import it.to.peppesca.pokemoninterview.R
import it.to.peppesca.pokemoninterview.databinding.ItemPokemonBinding
import it.to.peppesca.pokemoninterview.ui.list.model.PokemonModel

/**
 * [PokemonsAdapter] is the adapter that handles the user list
 */
class PokemonsAdapter(
    private val callback: OnItemSelected<PokemonModel>
) : PagingDataAdapter<PokemonModel, PokemonsAdapter.ViewHolder>(diffResult) {

    private var pokemonList = listOf<PokemonModel>()

    private companion object {
        val diffResult = object : ItemCallback<PokemonModel>() {
            override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean =
                oldItem == newItem

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            DataBindingUtil.inflate(
                inflater,
                R.layout.item_pokemon, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setPirateShip(pokemonList[position])
    }

    override fun getItemCount() = pokemonList.size

    inner class ViewHolder(var binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                binding.pokemonItem?.let {
            //        callback.onItemSelected(it)
                }
            }
        }

        fun setPirateShip(pirateShip: PokemonModel) {
      //      binding.pokemonItem = pirateShip
        }
    }
}
