package io.davidosemwota.data.source.local

import io.davidosemwota.data.network.responses.SuperheroResponse
import io.davidosemwota.data.source.Superhero
import io.davidosemwota.data.source.SuperheroSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeLocalSource(
    private val superheroStorage: MutableList<Superhero>
) : SuperheroSource {

    override suspend fun getSuperheros(): Flow<List<Superhero>> {
        return MutableStateFlow(superheroStorage)
    }

    override suspend fun save(superhero: Superhero) {
        superheroStorage.add(superhero)
    }

    override suspend fun deleteDatabase() {
        superheroStorage.clear()
    }

    override suspend fun fetchSuperheroesFromApi(): List<SuperheroResponse>? {
        TODO("Not yet implemented")
    }

    override suspend fun find(id: Int): Superhero? {
        return superheroStorage.find { it.id == id }
    }
}