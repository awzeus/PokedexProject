package com.awzeus.openpokedex.ui.discover

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.awzeus.openpokedex.R
import com.awzeus.openpokedex.databinding.FragmentDiscoverBinding


class DiscoverFragment : Fragment() {
    private lateinit var binding: FragmentDiscoverBinding
    private val discoverViewModel: DiscoverViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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
                //TODO update recycler view with this info
                binding.rvDiscoverEntries.layoutManager = LinearLayoutManager(view?.context)
                val adapter = DiscoverAdapter(tenPokemon)
                binding.rvDiscoverEntries.adapter = adapter
                /*
                for(pokemon in tenPokemon){
                    val id = pokemon.id
                    val name = pokemon.name
                    val type = pokemon.types.get(0).type.name
                    val hp = pokemon.stats.get(0).base_stat
                    val attack = pokemon.stats.get(1).base_stat
                    val defense = pokemon.stats.get(2).base_stat
                    val special_attack = pokemon.stats.get(3).base_stat
                    val special_defense = pokemon.stats.get(4).base_stat
                    val speed = pokemon.stats.get(5).base_stat
                    val sprite = pokemon.sprites.front_default
                    Log.d("ISTHISWORKING", "#$id $name $type\nHP: $hp Attack: $attack Defense: $defense, spc_a $special_attack spc_d $special_defense speed: $speed\nurl: $sprite\n\n")
                }*/
            }

        })
        discoverViewModel.isLoading.observe(viewLifecycleOwner, Observer { visibleStatus ->
            binding.pbIsLoading.isVisible = visibleStatus
        })

        return binding.root
    }
}