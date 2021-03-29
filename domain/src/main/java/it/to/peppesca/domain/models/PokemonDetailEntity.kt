package it.to.peppesca.domain.models

/**
 * Entity model for domain layer
 *
 * @property id as entity id
 * @property urlImage as image where to find image
 */
data class PokemonDetailEntity(val id: Int, val urlImage: String, val name: String)