package io.davidosemwota.data.network.responses

import androidx.annotation.Keep
import io.davidosemwota.data.util.defaultValue

@Keep
data class ImagesResponse(
        val xs: String = defaultValue,
        val sm: String = defaultValue,
        val md: String = defaultValue,
        val lg: String = defaultValue
)