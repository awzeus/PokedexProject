package com.awzeus.openpokedex.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.awzeus.openpokedex.databinding.FragmentSearchBinding
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.awzeus.openpokedex.R
import com.awzeus.openpokedex.domain.model.Pokemon
import com.awzeus.openpokedex.ui.util.ConvertPokemon
import com.awzeus.openpokedex.ui.util.PokemonListCallback


class SearchFragment : Fragment(), PokemonListCallback {
    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater, container, false).apply {
            viewLifecycleOwner
            searchViewModel
        }

        binding.etSearchFieldSearch.setOnEditorActionListener(OnEditorActionListener{ v, actionId, event ->
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    searchViewModel.getSinglePokemon(binding.etSearchFieldSearch.text.toString().lowercase())
                    binding.etSearchFieldSearch.text.clear()
                    return@OnEditorActionListener true
                }
            false
            })

        searchViewModel.searchModel.observe(viewLifecycleOwner,{ pokemonResult ->
            if (pokemonResult != null){
                val directions = SearchFragmentDirections.actionNavigationSearchToPokemonDetailFragment(ConvertPokemon().convertEntrytoPokemon(pokemonResult))
                NavHostFragment.findNavController(this).navigate(directions)
                //I had to do this next line because of the live data, I couldn't navigate back.
                // (Reason being is that it would navigate back pokemonResult would still be different than null and it would navigate back to the details page.
                // Temporary fix until I find a better solution. It also affects the NO RESULTS message
                searchViewModel.searchModel.postValue(null)
            }else{
                Toast.makeText(context, getString(R.string.no_results), Toast.LENGTH_SHORT).show()
            }
        })
        if (searchViewModel.getListHistory().isNotEmpty()){
            binding.ivPokeballSearch.isVisible = false
            binding.tvNoResultsSearch.isVisible = false
            binding.rvSearchHistory.layoutManager = LinearLayoutManager(view?.context)
            val adapter = SearchAdapter(searchViewModel.getListHistory().asReversed(),this)
            binding.rvSearchHistory.adapter = adapter
        }
        return binding.root
    }

    override fun onClick(pokemon: Pokemon) {
        val directions = SearchFragmentDirections.actionNavigationSearchToPokemonDetailFragment(pokemon)
        NavHostFragment.findNavController(this).navigate(directions)
        //I had to do this next line because of the live data, I couldn't navigate back. Temporary fix until I find a better solution.
        searchViewModel.searchModel.postValue(null)
    }
}