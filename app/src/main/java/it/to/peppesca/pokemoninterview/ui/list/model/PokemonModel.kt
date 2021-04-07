package it.to.peppesca.pokemoninterview.ui.list.model

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

/**
 * Pokemon model for the presentation layer
 *
 * @property id
 * @property urlImage
 */
@Parcelize
data class PokemonModel(
    val id: Int,
    val name: String,
    val urlImage: String,
    val type: List<String>,
    val baseExp: Int,
    val height: Int,
    val weight: Int,
    @ColorRes val colorResource: Int,
    @DrawableRes val iconResource: Int
) : Parcelable

