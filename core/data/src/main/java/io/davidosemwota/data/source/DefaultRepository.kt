package io.davidosemwota.data.source

import io.davidosemwota.data.mapper.Mapper
import io.davidosemwota.data.mapper.SuperheroMapper
import io.davidosemwota.data.network.NetworkState
import io.davidosemwota.data.network.responses.SuperheroResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.withContext

class DefaultRepository(
    private val localSource: SuperheroSource,
    private val remoteSource: SuperheroSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val superheroMapper: Mapper<SuperheroResponse, Superhero> = SuperheroMapper()
) : SuperheroRepository {

    override val networkState = MutableStateFlow<NetworkState>(NetworkState.Loading)

    override suspend fun getSuperheroes(): Flow<List<Superhero>> = withContext(ioDispatcher) {
        return@withContext localSource.getSuperheros()
    }

    override suspend fun fetchSuperheroesFromApi() = withContext(ioDispatcher) {
        networkState.value = NetworkState.Loading
        val apiResponse = remoteSource.fetchSuperheroesFromApi()

        when {
            apiResponse == null -> {
                networkState.value = NetworkState.Error
            }
            apiResponse.isEmpty() -> {
                networkState.value = NetworkState.Success(true)
            }

            apiResponse.isNotEmpty() -> {
                parseApiResponse(apiResponse)
                networkState.value = NetworkState.Success()
            }
        }
    }

    override suspend fun find(id: Int): Superhero? = withContext(ioDispatcher) {
        return@withContext localSource.find(id)
    }

    private suspend fun parseApiResponse(response: List<SuperheroResponse>) {
        localSource.deleteDatabase()
        response.forEach { superheroResponse ->
            localSource.save(superheroMapper.transform(superheroResponse) )
        }
    }
}