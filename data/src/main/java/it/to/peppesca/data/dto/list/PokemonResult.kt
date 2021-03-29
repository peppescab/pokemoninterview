package it.to.peppesca.data.dto.list


import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class PokemonResult(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)