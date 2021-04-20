package io.davidosemwota.data.network.responses

import androidx.annotation.Keep

@Keep
data class ImagesResponse(
     val xs: String,
     val sm: String,
     val md: String,
     val lg: String
)