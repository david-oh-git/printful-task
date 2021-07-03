package io.davidosemwota.superheroes_list.superheroes

import androidx.appcompat.widget.AppCompatImageView

sealed class ListOfSuperheroesViewEvent {

    data class OpenSuperhero(
        val id: Int,
        val imageView: AppCompatImageView
        ) : ListOfSuperheroesViewEvent()
}