package com.awzeus.openpokedex.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.awzeus.openpokedex.data.mockDataSource.PokemonHistoryDataSource
import com.awzeus.openpokedex.domain.model.PokemonHistoryModel

class SearchViewModel: ViewModel() {
    val pokemonHistoryModel = MutableLiveData<PokemonHistoryModel>()

    fun allPokemonHistory(){
        val allPokemon = PokemonHistoryDataSource.getAllPokeHistory()
    }

    fun pokemonHistoryEntry(){
        val currentPokemon = PokemonHistoryDataSource.getPokeHistory((0..4).random())
        pokemonHistoryModel.postValue(currentPokemon)
    }
}