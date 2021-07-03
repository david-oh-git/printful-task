package io.davidosemwota.data.network.services

import io.davidosemwota.data.network.responses.SuperheroResponse
import retrofit2.Response
import retrofit2.http.GET
/**
 * Akabab superhero API (https://akabab.github.io/superhero-api/api/) service.
 */
interface SuperheroApiService {
    /**
     * Fetches a list of all superheros.
     */
    @GET(SUPERHERO_ENDPOINT)
    suspend fun getSuperheros(): Response<List<SuperheroResponse>>

    companion object {
        const val SUPERHERO_ENDPOINT = "all.json"
    }
}