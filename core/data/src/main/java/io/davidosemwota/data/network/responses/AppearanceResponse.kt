package io.davidosemwota.data.network.responses

import androidx.annotation.Keep
import io.davidosemwota.data.util.defaultValue

@Keep
data class AppearanceResponse(
        val gender: String = defaultValue,
        val race: String = defaultValue,
        val height: List<String> = emptyList(),
        val weight: List<String> = emptyList(),
        val eyeColor: String = defaultValue,
        val hairColor: String = defaultValue
)