package it.to.peppesca.data.dto.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class Species(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)