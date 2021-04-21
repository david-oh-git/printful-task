package io.davidosemwota.data.network.responses

import androidx.annotation.Keep
import io.davidosemwota.data.util.defaultValue

@Keep
data class WorkResponse(
        val occupation: String = defaultValue,
        val base: String = defaultValue
)