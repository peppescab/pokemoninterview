package it.to.peppesca.data.dto.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import androidx.annotation.Keep

@Keep
@JsonClass(generateAdapter = true)
data class RedBlue(
    @Json(name = "back_default")
    val backDefault: String?,
    @Json(name = "back_gray")
    val backGray: String?,
    @Json(name = "front_default")
    val frontDefault: String?,
    @Json(name = "front_gray")
    val frontGray: String?
)