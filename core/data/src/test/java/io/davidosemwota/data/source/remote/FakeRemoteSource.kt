package io.davidosemwota.data.source.remote

import io.davidosemwota.data.network.responses.SuperheroResponse
import io.davidosemwota.data.source.Superhero
import io.davidosemwota.data.source.SuperheroSource
import kotlinx.coroutines.flow.Flow

class FakeRemoteSource(

) : SuperheroSource {

    override suspend fun getSuperheros(): Flow<List<Superhero>> {
        TODO("Not yet implemented")
    }

    override suspend fun save(superhero: Superhero) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDatabase() {
        TODO("Not yet implemented")
    }

    override suspend fun fetchSuperheroesFromApi(): List<SuperheroResponse>? {
        TODO("Not yet implemented")
    }

    override suspend fun find(id: Int): Superhero? {
        TODO("Not yet implemented")
    }
}