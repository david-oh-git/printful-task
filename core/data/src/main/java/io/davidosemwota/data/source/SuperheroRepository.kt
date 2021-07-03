package io.davidosemwota.data.source

import io.davidosemwota.data.network.NetworkState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface SuperheroRepository {

    val networkState: MutableStateFlow<NetworkState>

    suspend fun getSuperheroes(): Flow<List<Superhero>>

    suspend fun fetchSuperheroesFromApi()

    suspend fun find(id: Int): Superhero?
}