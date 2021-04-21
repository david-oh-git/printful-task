package io.davidosemwota.superheroes_list.superheroes.adaptors

import android.view.LayoutInflater
import io.davidosemwota.superheroes_list.SuperheroItem
import io.davidosemwota.superheroes_list.databinding.SuperheroItemBinding
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
    fun bind(superheroItem: SuperheroItem) {
        binding.apply {
            name.text = superheroItem.name
            image.setImage(superheroItem.imageUrl, null)
        }
    }
}