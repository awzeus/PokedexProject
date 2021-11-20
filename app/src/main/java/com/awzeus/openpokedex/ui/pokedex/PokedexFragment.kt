package com.awzeus.openpokedex.ui.pokedex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.awzeus.openpokedex.databinding.FragmentPokedexBinding
import com.awzeus.openpokedex.domain.model.Pokemon
import com.awzeus.openpokedex.ui.util.PokemonListCallback

class PokedexFragment : Fragment(), PokemonListCallback {
    private lateinit var viewModel: PokedexViewModel
    private lateinit var binding: FragmentPokedexBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokedexBinding.inflate(inflater,container,false)
        val pokemonFactory = PokedexViewModel.PokemonFactory()
        viewModel = ViewModelProvider(this,pokemonFactory).get(PokedexViewModel::class.java)

        viewModel.pokemon.observe(viewLifecycleOwner,{ listOfSavedPokemon ->
            if(!listOfSavedPokemon.isNullOrEmpty()){
                binding.ivPokeballPokedex.isVisible = false
                binding.tvNoResultsPokedex.isVisible = false
                binding.rvPokedexEntries.layoutManager = LinearLayoutManager(view?.context)
                val adapter = PokedexAdapter(listOfSavedPokemon,this)
                binding.rvPokedexEntries.adapter = adapter
            }
        })

        binding.etSearchFieldPokedex.doOnTextChanged { text, start, before, count ->
            viewModel.getFilteredPokemon("%${text}%")
        }


        viewModel.getAll()

        return binding.root
    }

    override fun onClick(pokemon: Pokemon) {
        val directions = PokedexFragmentDirections.actionNavigationPokedexToPokemonDetailFragment(pokemon)
        NavHostFragment.findNavController(this).navigate(directions)
    }

}