package io.davidosemwota.data.source

import io.davidosemwota.data.network.responses.SuperheroResponse

interface SuperheroSource {

    suspend fun getSuperheros(): List<SuperheroResponse>
}