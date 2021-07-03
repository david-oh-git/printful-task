package io.davidosemwota.data.source.local

import io.davidosemwota.data.network.responses.SuperheroResponse
import io.davidosemwota.data.source.Superhero
import io.davidosemwota.data.source.SuperheroSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class LocalSource(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val superheroDao: SuperheroDao
) : SuperheroSource {

    override suspend fun getSuperheros(): Flow<List<Superhero>> = withContext(ioDispatcher) {
        return@withContext superheroDao.getSuperheroes()
    }

    override suspend fun save(superhero: Superhero) = withContext(ioDispatcher) {
        superheroDao.save(superhero)
    }

    override suspend fun deleteDatabase() {
        superheroDao.emptyDatabase()
    }

    override suspend fun find(id: Int): Superhero? = withContext(ioDispatcher) {
        return@withContext superheroDao.find(id)
    }

    override suspend fun fetchSuperheroesFromApi(): List<SuperheroResponse>? {
        TODO("Not required")
    }
}