package io.davidosemwota.superheroes_list.superhero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import io.davidosemwota.data.Graph
import io.davidosemwota.superheroes_list.R
import io.davidosemwota.superheroes_list.SuperheroItem
import io.davidosemwota.superheroes_list.databinding.FragmentSuperheroBinding
import io.davidosemwota.ui.extentions.observe
import io.davidosemwota.ui.extentions.setImage
import io.davidosemwota.ui.extentions.setSharedElementTransitions

class SuperheroFragment : Fragment() {

    private lateinit var binding: FragmentSuperheroBinding
    private val args: SuperheroFragmentArgs by navArgs()
    private val viewModel: SuperheroViewModel by viewModels {
        SuperheroViewModelFactory(
                Graph.provideRepository(requireContext())
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSharedElementTransitions()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSuperheroBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpToolbar()
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
        observe(viewModel.superheroItem, ::onViewDataChange)
        viewModel.fetchItem(args.id)
    }

    private fun onViewDataChange(superheroItem: SuperheroItem) {
        binding.collapsingToolbar.title = superheroItem.name
        binding.image.apply {
            setImage(superheroItem.imageUrl, null)
            transitionName = superheroItem.id.toString()
        }
        requireActivity().actionBar?.title = superheroItem.name

        binding.includeSuperheroBody.apply {
            alterEgo.title.text = getString(R.string.alterEgo_title)
            alterEgo.content.text = superheroItem.alterEgos
            publisher.title.text = getString(R.string.publisher_title)
            publisher.content.text = superheroItem.publisher
            firstAppearance.title.text = getString(R.string.first_appearance_title)
            firstAppearance.content.text = superheroItem.firstAppearance
            groupAffiliation.title.text = getString(R.string.group_affiliation)
            groupAffiliation.content.text = superheroItem.groupAffiliation
        }
    }

    private fun setUpToolbar() {
        (requireActivity() as AppCompatActivity).run {
            setSupportActionBar(binding.toolbar)
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        }
    }
}