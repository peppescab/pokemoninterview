package it.to.peppesca.data.dto.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class GenerationIi(
    @Json(name = "crystal")
    val crystal: Crystal,
    @Json(name = "gold")
    val gold: Gold,
    @Json(name = "silver")
    val silver: Silver
)