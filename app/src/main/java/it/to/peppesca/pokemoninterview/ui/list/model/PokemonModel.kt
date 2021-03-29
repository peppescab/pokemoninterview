package it.to.peppesca.pokemoninterview.ui.list.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Pokemon model for the presentation layer
 *
 * @property id
 * @property urlImage
 */
@Parcelize
data class PokemonModel(val id: String, val urlImage: String, val name: String) : Parcelable