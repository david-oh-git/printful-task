package io.davidosemwota.superheroes_list.superhero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import io.davidosemwota.superheroes_list.R
import io.davidosemwota.superheroes_list.databinding.FragmentSuperheroBinding
import io.davidosemwota.ui.extentions.setSharedElementTransitions

class SuperheroFragment : Fragment() {

    private lateinit var binding: FragmentSuperheroBinding
    private val args: SuperheroFragmentArgs by navArgs()

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
    }

    private fun setUpToolbar() {
        (requireActivity() as AppCompatActivity).run {
            setSupportActionBar(binding.toolbar)
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        }
    }
}