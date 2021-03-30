package it.to.peppesca.domain.models

/**
 * Entity model for domain layer
 *
 * @property id as entity id
 * @property urlImage as image where to find image
 */
data class PokemonDetailEntity(
    val id: Long,
    val name: String,
    val urlImage: String,
    val type: List<String>,
    val baseExp: Int,
    val height: Int,
    var weight: Int
)