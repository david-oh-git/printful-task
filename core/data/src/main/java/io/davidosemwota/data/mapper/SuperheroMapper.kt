package io.davidosemwota.data.mapper

import io.davidosemwota.data.network.responses.SuperheroResponse
import io.davidosemwota.data.source.Superhero

class SuperheroMapper : Mapper<SuperheroResponse, Superhero> {

    override suspend fun transform(from: SuperheroResponse): Superhero {
        return Superhero(
            id = 0,
            name = from.name,
            alterEgos = from.biography.alterEgos,
            firstAppearance = from.biography.firstAppearance,
            publisher = from.biography.publisher,
            imageUrl = from.images.lg,
            groupAffiliation = from.connections.groupAffiliation
        )
    }
}