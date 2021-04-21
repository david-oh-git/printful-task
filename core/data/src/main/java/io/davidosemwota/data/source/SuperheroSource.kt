package io.davidosemwota.data.source

import io.davidosemwota.data.network.responses.SuperheroResponse
import kotlinx.coroutines.flow.Flow

interface SuperheroSource {

    suspend fun getSuperheros(): Flow<List<Superhero>>

    suspend fun save(superhero: Superhero)

    suspend fun deleteDatabase()

    suspend fun fetchSuperheroesFromApi(): List<SuperheroResponse>?

    suspend fun find(id: Int): Superhero?
}