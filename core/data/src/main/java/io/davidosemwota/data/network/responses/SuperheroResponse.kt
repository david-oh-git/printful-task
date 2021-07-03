package io.davidosemwota.data.network.responses

import androidx.annotation.Keep
import io.davidosemwota.data.util.defaultValue

@Keep
data class SuperheroResponse(
        val id: Int,
        val name: String = defaultValue,
        val slug: String = defaultValue,
        val powerstats: PowerStatsResponse?,
        val appearance: AppearanceResponse?,
        val biography: BiographyResponse?,
        val work: WorkResponse?,
        val connections: ConnectionsResponse?,
        val images: ImagesResponse?
)