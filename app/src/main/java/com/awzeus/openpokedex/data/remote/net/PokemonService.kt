package com.awzeus.openpokedex.data.remote.net

import com.awzeus.openpokedex.data.remote.RetrofitBuilder
import com.awzeus.openpokedex.data.remote.model.PokemonEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonService {

    private val retrofit = RetrofitBuilder.getRetrofit()

    suspend fun getTenPokemon(): List<PokemonEntry>{
        return withContext(Dispatchers.IO) {
            val listOfPokemon = mutableListOf<PokemonEntry>()
            for (x in 1..10){
                val entry = retrofit.create(PokemonRemoteApi::class.java).getPokemonById((1..898).random())
                entry.body()?.let { listOfPokemon.add(it) }
            }

            listOfPokemon
        }
    }
}