package io.davidosemwota.superheroes_list.superheroes.adaptors

import android.view.LayoutInflater
import io.davidosemwota.superheroes_list.SuperheroItem
import io.davidosemwota.superheroes_list.databinding.SuperheroItemBinding
import io.davidosemwota.superheroes_list.superheroes.ListOfSuperheroesViewModel
import io.davidosemwota.ui.base.BaseViewHolder
import io.davidosemwota.ui.extentions.setImage

class SuperheroViewHolder(
    inflater: LayoutInflater
) : BaseViewHolder<SuperheroItemBinding>(
    SuperheroItemBinding.inflate(inflater)
) {

    /**
     * Bind data to viewHolder
     */
    fun bind(superheroItem: SuperheroItem, viewModel: ListOfSuperheroesViewModel) {
        binding.apply {
            name.text = superheroItem.name
            image.setImage(superheroItem.imageUrl, null)
            image.transitionName = superheroItem.id.toString()
            cardViewContainer.setOnClickListener {
                viewModel.openSuperheroFragment(superheroItem.id, this.image)
            }
        }
    }
}