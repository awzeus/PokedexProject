package com.awzeus.openpokedex.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.awzeus.openpokedex.data.local.database.DatabaseManager
import com.awzeus.openpokedex.data.local.repository.PokedexRepository
import com.awzeus.openpokedex.data.local.source.PokedexDataSource
import com.awzeus.openpokedex.domain.model.Pokemon
import kotlinx.coroutines.launch

class PokemonDetailViewModel(private val pokedexRepository: PokedexRepository): ViewModel() {
    val savedIds = MutableLiveData<List<Int>>()
    fun addToPokedex(pokemon: Pokemon){
        viewModelScope.launch {
            pokedexRepository.add(pokemon)
        }
    }

    fun deletePokemon(pokemon: Pokemon){
        viewModelScope.launch {
            pokedexRepository.remove(pokemon)
        }
    }

    fun getPokedexIds(){
        viewModelScope.launch {
            val pokeList = pokedexRepository.getMyPokemon().value
            //savedIds.postValue(pokeList)
            var pokeIds = mutableListOf<Int>()
            if(!pokeList.isNullOrEmpty()){
                for(pokemon in pokeList){
                    pokeIds.add(pokemon.id)
                }
                savedIds.postValue(pokeIds)
            }
        }
    }

    class PokemonFactory: ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(PokemonDetailViewModel::class.java)){
                return PokemonDetailViewModel(
                    pokedexRepository = PokedexDataSource(DatabaseManager.instance.database.pokemonDao())
                ) as T
            }
            throw Exception("No class type supported")
        }
    }
}