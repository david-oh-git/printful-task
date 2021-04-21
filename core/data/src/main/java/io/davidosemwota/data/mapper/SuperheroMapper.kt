package io.davidosemwota.data.mapper

import io.davidosemwota.data.network.responses.SuperheroResponse
import io.davidosemwota.data.source.Superhero
import io.davidosemwota.data.util.defaultValue

class SuperheroMapper : Mapper<SuperheroResponse, Superhero> {

    override suspend fun transform(from: SuperheroResponse): Superhero {
        return Superhero(
            id = 0,
            name = from.name,
            alterEgos = from.biography?.alterEgos ?: defaultValue,
            firstAppearance = from.biography?.firstAppearance ?: defaultValue,
            publisher = from.biography?.publisher ?: defaultValue,
            imageUrl = from.images?.lg ?: defaultValue,
            groupAffiliation = from.connections?.groupAffiliation ?: defaultValue
        )
    }
}