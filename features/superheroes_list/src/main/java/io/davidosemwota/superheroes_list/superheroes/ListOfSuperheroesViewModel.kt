package io.davidosemwota.superheroes_list.superheroes

import androidx.lifecycle.*
import io.davidosemwota.data.mapper.Mapper
import io.davidosemwota.data.network.NetworkState
import io.davidosemwota.data.source.Superhero
import io.davidosemwota.data.source.SuperheroRepository
import io.davidosemwota.superheroes_list.SuperheroItem
import io.davidosemwota.superheroes_list.SuperheroItemMapper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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
                if(it.isEmptyResponse){
                    ListOfSuperheroesViewState.Empty
                }else{
                    ListOfSuperheroesViewState.Loaded
                }
            }

            is NetworkState.Loading -> {
                if (superheroes.value?.isNotEmpty() == true){
                    ListOfSuperheroesViewState.Refreshing
                }
                ListOfSuperheroesViewState.Loading
            }

            is NetworkState.Error -> {
                ListOfSuperheroesViewState.Error
            }
        }
    }

    fun refresh() {
        viewModelScope.launch {
            repository.fetchSuperheroesFromApi()
        }
    }
}

@Suppress("UNCHECKED_CAST")
class ListOfSuperheroesViewModelFactory(
    private val repository: SuperheroRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        ListOfSuperheroesViewModel(repository) as T
}