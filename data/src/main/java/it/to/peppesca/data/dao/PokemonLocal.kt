package it.to.peppesca.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import it.to.peppesca.data.converters.Converter

/**
 *This class represent a Pokemon stored in local db.
 *
 * @property id as the id of pokemon.
 * @property name as the name of this pokemon.
 * @property urlImage as the url image for this pokemon.
 * @property types as the list of types for a pokemon (it could be used an enum for those types)
 * @property baseExp is the base experience of this pokemon.
 * @property height as the height of the pokemon.
 * @property weight as the weight of the pokemon.
 */
@Entity
@TypeConverters(Converter::class)
data class PokemonLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "urlImage") var urlImage: String,
    @ColumnInfo(name = "types") var type: List<String>,
    @ColumnInfo(name = "base_exp") var baseExp: Int,
    @ColumnInfo(name = "height") var height: Int,
    @ColumnInfo(name = "weight") var weight: Int
)