package io.davidosemwota.superheroes_list

data class SuperheroItem(
    val id: Int,
    val name: String,
    val alterEgos: String,
    val firstAppearance: String,
    val publisher: String,
    val groupAffiliation: String,
    val imageUrl: String
)