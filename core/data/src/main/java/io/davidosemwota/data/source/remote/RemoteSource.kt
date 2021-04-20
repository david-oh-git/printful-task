package io.davidosemwota.data.source.remote

import io.davidosemwota.data.network.responses.Result
import io.davidosemwota.data.network.responses.SuperheroResponse
import io.davidosemwota.data.network.services.SuperheroApiService
import io.davidosemwota.data.source.Superhero
import io.davidosemwota.data.source.SuperheroSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber

class RemoteSource(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val superheroApiService: SuperheroApiService
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

    override suspend fun fetchSuperheroesFromApi(): List<SuperheroResponse>? =
        withContext(ioDispatcher) {

        return@withContext safeApiCall(
            call = { superheroApiService.getSuperheros() },
            errorMsg = "Error fetching data.."
        )
    }

    private suspend fun <T : Any> safeApiCall(
        call: suspend () -> Response<T>,
        errorMsg: String
    ): T? {

        val result: Result<T> = safeApiResult(call, errorMsg)
        var data: T? = null

        when (result) {
            is Result.Success -> data = result.data
            is Result.Error -> {
                Timber.d("Error !!! : $errorMsg")
            }
        }

        return data
    }

    private suspend fun <T : Any> safeApiResult(
        call: suspend () -> Response<T>,
        errorMsg: String
    ): Result<T> {

        try {
            val response = call.invoke()
            if (response.isSuccessful) return Result.Success(response.body()!!)

            return Result.Error(
                Exception("Error occurred while getting safe api result, ERROR - $errorMsg")
            )
        } catch (e: Exception) {
            return Result.Error(
                Exception("Error occurred while getting safe api result, ERROR - $errorMsg")
            )
        }
    }
}