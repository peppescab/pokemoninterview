package it.to.peppesca.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO add documentation
/**
 *
 */
@Entity
data class PokemonLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "urlImage") var urlImage: String,
    @ColumnInfo(name = "type") var type: String
)