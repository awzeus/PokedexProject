package com.awzeus.openpokedex.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awzeus.openpokedex.data.remote.model.PokemonEntry
import com.awzeus.openpokedex.domain.model.Pokemon
import com.awzeus.openpokedex.domain.usecase.GetSpecificPokemon
import com.awzeus.openpokedex.ui.util.ConvertPokemon
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {
    val searchModel = MutableLiveData<PokemonEntry?>()
    var pokemonResult = GetSpecificPokemon()
    var pokemonHistoryList: MutableList<Pokemon> = mutableListOf()

    fun getSinglePokemon(searchCriteria: String){
        viewModelScope.launch {
            var result = pokemonResult.invoke(searchCriteria)
            searchModel.postValue(result)
            if (result != null){
                pokemonHistoryList.add(ConvertPokemon().convertEntrytoPokemon(result))
            }
        }
    }

    fun getListHistory(): MutableList<Pokemon>{
        return pokemonHistoryList
    }
}