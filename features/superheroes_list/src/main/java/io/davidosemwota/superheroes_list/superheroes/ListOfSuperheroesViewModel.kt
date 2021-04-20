package io.davidosemwota.superheroes_list.superheroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import io.davidosemwota.data.mapper.Mapper
import io.davidosemwota.data.network.NetworkState
import io.davidosemwota.data.source.Superhero
import io.davidosemwota.data.source.SuperheroRepository
import io.davidosemwota.superheroes_list.SuperheroItem
import io.davidosemwota.superheroes_list.SuperheroItemMapper
import kotlinx.coroutines.flow.collect

class ListOfSuperheroesViewModel(
        private val repository: SuperheroRepository,
        private val superheroItemMapper: Mapper<Superhero, SuperheroItem> = SuperheroItemMapper()
) : ViewModel() {

    val superheroes = liveData {
        repository.getSuperheroes()
                .collect { listOfSuperheroes ->
                    emit( listOfSuperheroes.map { superheroItemMapper.transform(it) })
                 }
    }

    val networkState: LiveData<NetworkState> = liveData {
        repository.networkState
            .collect { emit(it) }
    }

    val state = Transformations.map(networkState) {

        when(it) {
            is NetworkState.Success -> {

            }

            is NetworkState.Loading -> {

            }

            is NetworkState.Error -> {

            }
        }
    }
}