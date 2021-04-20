package io.davidosemwota.data.network.responses

data class PowerStatsResponse(
        val intelligence: Int,
        val strength: Int,
        val speed: Int,
        val durability: Int,
        val power: Int,
        val combat: Int
)