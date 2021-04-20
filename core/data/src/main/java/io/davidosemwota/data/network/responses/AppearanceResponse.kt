package io.davidosemwota.data.network.responses

data class AppearanceResponse(
     val gender: String,
     val race: String,
     val height: List<String>,
     val weight: List<String>,
     val eyeColor: String,
     val hairColor: String
)