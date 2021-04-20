package io.davidosemwota.data.network.responses

import androidx.annotation.Keep

@Keep
data class ConnectionsResponse(
        val groupAffiliation: String,
        val relatives: String
)