package io.davidosemwota.data.network.responses

import androidx.annotation.Keep

@Keep
data class AppearanceResponse(
     val gender: String,
     val race: String,
     val height: List<String>,
     val weight: List<String>,
     val eyeColor: String,
     val hairColor: String
)