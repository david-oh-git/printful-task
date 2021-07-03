package io.davidosemwota.data.network.responses

import androidx.annotation.Keep
import io.davidosemwota.data.util.defaultValue

@Keep
class BiographyResponse(
        val fullName: String = defaultValue,
        val alterEgos: String = defaultValue,
        val aliases: List<String> = emptyList(),
        val placeOfBirth: String = defaultValue,
        val firstAppearance: String = defaultValue,
        val publisher: String = defaultValue,
        val alignment: String = defaultValue
)