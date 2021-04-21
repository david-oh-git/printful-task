package io.davidosemwota.data.network.responses

import androidx.annotation.Keep
import io.davidosemwota.data.util.defaultValue

@Keep
data class ConnectionsResponse(
        val groupAffiliation: String = defaultValue,
        val relatives: String = defaultValue
)