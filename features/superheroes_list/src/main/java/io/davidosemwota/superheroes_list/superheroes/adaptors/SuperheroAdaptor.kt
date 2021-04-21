package io.davidosemwota.superheroes_list.superheroes.adaptors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.davidosemwota.superheroes_list.SuperheroItem
import io.davidosemwota.ui.base.BaseListAdaptor

/**
 * Adaptor for the [RecyclerView] that represents the list of [SuperheroItem] .
 */
class SuperheroAdaptor : BaseListAdaptor<SuperheroItem>(
    itemsSame = { old,new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    /**
     * Called when recyclerView needs a new [RecyclerView.ViewHolder] for the view type.
     * @param parent The parent view into which the new ViewHolder is added.
     * @param inflater Instantiate the xml layout for the view.
     * @param viewType Specifies the new view type.
     * @return A new viewHolder for the viewType.
     *
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ) = SuperheroViewHolder(inflater)

    /**
     * Called by recyclerView to display data for a specified position.
     *
     * @param holder The viewHolder who's data is to be updated.
     * @param position The viewHolder's position.
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is SuperheroViewHolder -> holder.bind(getItem(position))
        }
    }
}