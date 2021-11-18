package com.awzeus.openpokedex.ui.discover

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awzeus.openpokedex.data.remote.model.PokemonEntry
import com.awzeus.openpokedex.domain.usecase.GetRandomPokemon
import kotlinx.coroutines.launch

class DiscoverViewModel : ViewModel() {
    val discoverModel = MutableLiveData<List<PokemonEntry>?>()
    val isLoading = MutableLiveData<Boolean>()
    var getRandomPokemon = GetRandomPokemon()

    fun getTenPokemon(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getRandomPokemon()
            discoverModel.postValue(result)
            isLoading.postValue(false)
        }
    }
}