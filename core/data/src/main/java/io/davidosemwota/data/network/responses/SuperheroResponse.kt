package io.davidosemwota.data.network.responses

data class SuperheroResponse(
        val id: Int,
        val name: String,
        val slug: String,
        val powerstats: PowerStatsResponse,
        val appearance: AppearanceResponse,
        val biography: BiographyResponse,
        val work: WorkResponse,
        val connections: ConnectionsResponse,
        val images: ImagesResponse
)