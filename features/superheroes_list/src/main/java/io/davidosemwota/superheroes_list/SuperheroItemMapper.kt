package io.davidosemwota.superheroes_list

import io.davidosemwota.data.mapper.Mapper
import io.davidosemwota.data.source.Superhero

class SuperheroItemMapper : Mapper<Superhero, SuperheroItem> {

    override suspend fun transform(from: Superhero): SuperheroItem {
        return SuperheroItem(
            id = from.id,
            imageUrl = from.imageUrl,
            groupAffiliation = from.groupAffiliation,
            publisher = from.publisher,
            firstAppearance = from.firstAppearance,
            alterEgos = from.alterEgos,
            name = from.name
        )
    }
}