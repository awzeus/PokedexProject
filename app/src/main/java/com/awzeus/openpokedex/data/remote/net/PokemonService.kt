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
                val entry = retrofit.create(PokemonRemoteApi::class.java).getPokemonByCriteria((1..898).random().toString())
                entry.body()?.let { listOfPokemon.add(it) }
            }
            listOfPokemon
        }
    }

    suspend fun getSpecificPokemon(searchCriteria: String) : PokemonEntry? {
        return withContext(Dispatchers.IO){
            var onePokemon: PokemonEntry? = null
            val entry = retrofit.create(PokemonRemoteApi::class.java).getPokemonByCriteria(searchCriteria)
            entry.body()?.let { onePokemon = it }
            onePokemon
        }
    }
}