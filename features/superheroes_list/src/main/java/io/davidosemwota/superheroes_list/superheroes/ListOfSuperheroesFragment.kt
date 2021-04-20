package io.davidosemwota.superheroes_list.superheroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.davidosemwota.superheroes_list.databinding.FragmentSuperheroesBinding

class ListOfSuperheroesFragment : Fragment() {

    private lateinit var binding: FragmentSuperheroesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSuperheroesBinding.inflate(inflater)
        return binding.root
    }
}