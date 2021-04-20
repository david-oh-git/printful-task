package io.davidosemwota.data

import io.davidosemwota.data.network.SuperheroApiFactory
import io.davidosemwota.data.network.services.SuperheroApiService

object Graph {

    val superheroApiService: SuperheroApiService by lazy {
        SuperheroApiFactory.provideSuperheroApiService()
    }
}