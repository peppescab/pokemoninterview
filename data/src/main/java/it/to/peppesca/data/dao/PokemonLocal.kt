package it.to.peppesca.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.squareup.moshi.Json
import it.to.peppesca.data.converters.Converter

//TODO add documentation
/**
 *
 */
@Entity
@TypeConverters(Converter::class)
data class PokemonLocal(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "urlImage") var urlImage: String,
    @ColumnInfo(name = "types") var type: List<String>,
    @ColumnInfo(name = "base_exp") var baseExp: Int,
    @ColumnInfo(name = "height") var height: Int,
    @ColumnInfo(name = "weight") var weight: Int
)