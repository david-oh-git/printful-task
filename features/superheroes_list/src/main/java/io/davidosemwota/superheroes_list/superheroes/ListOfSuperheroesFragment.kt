package io.davidosemwota.superheroes_list.superheroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import io.davidosemwota.data.Graph
import io.davidosemwota.superheroes_list.SuperheroItem
import io.davidosemwota.superheroes_list.databinding.FragmentSuperheroesBinding
import io.davidosemwota.superheroes_list.superheroes.adaptors.SuperheroAdaptor
import io.davidosemwota.ui.extentions.observe
import io.davidosemwota.ui.extentions.visible

class ListOfSuperheroesFragment : Fragment() {

    private lateinit var binding: FragmentSuperheroesBinding

    private val viewModel: ListOfSuperheroesViewModel by viewModels {
        ListOfSuperheroesViewModelFactory(
            Graph.provideRepository(requireContext())
        )
    }
    private val _adaptor: SuperheroAdaptor by lazy {
        SuperheroAdaptor(viewModel)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSuperheroesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.superheroes, ::onViewDataChange)
        observe(viewModel.state, ::onViewStateChange)
        observe(viewModel.isCacheAvailable, ::onCacheDataIsAvailable)
        observe(viewModel.event, ::onViewEventChange)
        initRecyclerView()
    }

    private fun onViewDataChange(data: List<SuperheroItem>) {
        _adaptor.submitList(data)
    }

    private fun onViewStateChange(viewState: ListOfSuperheroesViewState) {
        binding.swipeRefreshlayout.isRefreshing = viewState.isRefreshing()
        when (viewState) {
            is ListOfSuperheroesViewState.Error -> {
                errorViewState()
            }

            is ListOfSuperheroesViewState.Loading -> {
                loadingViewState()
            }

            is ListOfSuperheroesViewState.Loaded -> {
                loadedViewState()
            }

            is ListOfSuperheroesViewState.Empty -> {
                emptyViewState()
            }

            is ListOfSuperheroesViewState.Refreshing -> {
            }
        }
    }

    private fun onViewEventChange(viewEvent: ListOfSuperheroesViewEvent) {
        when(viewEvent) {
            is ListOfSuperheroesViewEvent.OpenSuperhero -> {
                navigateToSuperheroFragment(viewEvent.id, viewEvent.imageView)
            }
        }
    }

    private fun onCacheDataIsAvailable(isCacheAvailable: Boolean) {
        if (!isCacheAvailable)
            viewModel.refresh()
        else
            loadedViewState()
    }

    private fun errorViewState() {
        binding.includeListError.root.visible = true
        binding.includeListEmpty.root.visible = false
        binding.includeListLoaded.root.visible = false
        binding.includeListLoading.root.visible = false
    }

    private fun loadingViewState() {
        binding.includeListLoading.root.visible = true
        binding.includeListError.root.visible = false
        binding.includeListEmpty.root.visible = false
        binding.includeListLoaded.root.visible = false
    }

    private fun loadedViewState() {
        binding.includeListLoaded.root.visible = true
        binding.includeListLoading.root.visible = false
        binding.includeListError.root.visible = false
        binding.includeListEmpty.root.visible = false
    }

    private fun emptyViewState() {
        binding.includeListEmpty.root.visible = true
        binding.includeListError.root.visible = false
        binding.includeListLoaded.root.visible = false
        binding.includeListLoading.root.visible = false
    }

    private fun initRecyclerView() {
        binding.includeListLoaded.superheroesList.apply {
            adapter = _adaptor
        }

        binding.swipeRefreshlayout.setOnRefreshListener {
            viewModel.refresh()
        }
    }

    private fun navigateToSuperheroFragment(
        id: Int,
        imageView: AppCompatImageView
    ) {
        val action = ListOfSuperheroesFragmentDirections
            .actionListOfSuperheroesFragmentToSuperheroFragment(id)
        val extras = FragmentNavigatorExtras(
            imageView to id.toString()
        )
        findNavController().navigate(action, extras)
    }
}