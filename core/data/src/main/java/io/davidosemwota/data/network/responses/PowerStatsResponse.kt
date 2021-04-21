package io.davidosemwota.data.network.responses

import androidx.annotation.Keep

@Keep
data class PowerStatsResponse(
        val intelligence: Int = 0,
        val strength: Int = 0,
        val speed: Int = 0,
        val durability: Int = 0,
        val power: Int = 0,
        val combat: Int = 0
)