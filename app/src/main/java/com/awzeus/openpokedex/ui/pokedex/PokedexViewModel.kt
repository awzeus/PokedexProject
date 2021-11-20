package com.awzeus.openpokedex.ui.pokedex

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.awzeus.openpokedex.data.local.database.DatabaseManager
import com.awzeus.openpokedex.data.local.repository.PokedexRepository
import com.awzeus.openpokedex.data.local.source.PokedexDataSource
import com.awzeus.openpokedex.domain.model.Pokemon
import kotlinx.coroutines.launch

class PokedexViewModel(private val pokedexRepository: PokedexRepository): ViewModel() {
    val pokemon = MutableLiveData<List<Pokemon>>()

    fun getAll(){
        viewModelScope.launch {
            pokemon.value = pokedexRepository.getMyPokemon().value
        }
    }

    class PokemonFactory: ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(PokedexViewModel::class.java)){
                return PokedexViewModel(
                    pokedexRepository = PokedexDataSource(DatabaseManager.instance.database.pokemonDao())
                ) as T
            }
            throw Exception("No class type supported")
        }
    }
}