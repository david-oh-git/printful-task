package io.davidosemwota.data.network.responses

import androidx.annotation.Keep

@Keep
data class PowerStatsResponse(
        val intelligence: Int,
        val strength: Int,
        val speed: Int,
        val durability: Int,
        val power: Int,
        val combat: Int
)