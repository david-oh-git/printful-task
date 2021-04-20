package io.davidosemwota.data.network.responses

class BiographyResponse(
        val fullName: String,
        val alterEgos: String,
        val aliases: List<String>,
        val placeOfBirth: String,
        val firstAppearance: String,
        val publisher: String,
        val alignment: String
)