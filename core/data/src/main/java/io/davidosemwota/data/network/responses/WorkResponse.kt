package io.davidosemwota.data.network.responses

import androidx.annotation.Keep

@Keep
data class WorkResponse(
        val occupation: String,
        val base: String
)