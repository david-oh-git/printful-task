package io.davidosemwota.superheroes_list.superhero

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import io.davidosemwota.data.mapper.Mapper
import io.davidosemwota.data.source.Superhero
import io.davidosemwota.data.source.SuperheroRepository
import io.davidosemwota.superheroes_list.SuperheroItem
import io.davidosemwota.superheroes_list.SuperheroItemMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperheroViewModel(
        private val repository: SuperheroRepository,
        private val superheroItemMapper: Mapper<Superhero, SuperheroItem> = SuperheroItemMapper()
) : ViewModel() {

    private val _superheroItem = MutableLiveData<SuperheroItem>()
    val superheroItem: LiveData<SuperheroItem> = _superheroItem

    fun fetchItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val superhero = repository.find(id)
            _superheroItem.postValue(superhero?.let { superheroItemMapper.transform(it) })
        }
    }
}

@Suppress("UNCHECKED_CAST")
class SuperheroViewModelFactory(
        private val repository: SuperheroRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            SuperheroViewModel(repository) as T
}