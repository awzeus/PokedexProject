package com.awzeus.openpokedex.ui.discover

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.awzeus.openpokedex.databinding.FragmentDiscoverBinding
import com.awzeus.openpokedex.domain.model.Pokemon
import com.awzeus.openpokedex.ui.util.PokemonListCallback
import androidx.navigation.fragment.NavHostFragment

class DiscoverFragment : Fragment(), PokemonListCallback {
    private lateinit var binding: FragmentDiscoverBinding
    private val discoverViewModel: DiscoverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDiscoverBinding.inflate(inflater, container, false).apply {
            viewLifecycleOwner
            discoverViewModel
        }
        discoverViewModel.getTenPokemon()
        discoverViewModel.discoverModel.observe(viewLifecycleOwner, Observer { tenPokemon ->
            if (tenPokemon != null) {
                binding.rvDiscoverEntries.layoutManager = LinearLayoutManager(view?.context)
                val adapter = DiscoverAdapter(tenPokemon,this)
                binding.rvDiscoverEntries.adapter = adapter
            }

        })
        discoverViewModel.isLoading.observe(viewLifecycleOwner, Observer { visibleStatus ->
            binding.pbIsLoading.isVisible = visibleStatus
            binding.rvDiscoverEntries.isVisible = !visibleStatus
        })
        return binding.root
    }

    override fun onClick(pokemon: Pokemon) {
        val directions = DiscoverFragmentDirections.actionNavigationDiscoverToPokemonDetailFragment(pokemon)
        NavHostFragment.findNavController(this).navigate(directions)
    }
}