package com.awzeus.openpokedex.data.repository

import com.awzeus.openpokedex.data.local.PokemonDataSource
import com.awzeus.openpokedex.data.remote.model.PokemonEntry
import com.awzeus.openpokedex.data.remote.net.PokemonService

class PokemonRepository {
    private val api = PokemonService()

    suspend fun getTenPokemon(): List<PokemonEntry>{
        val response = api.getTenPokemon()
        PokemonDataSource.pokemon = response
        return response
    }

    suspend fun getSpecificPokemon(searchCriteria:String) : PokemonEntry? {
        val response: PokemonEntry? = api.getSpecificPokemon(searchCriteria)
        PokemonDataSource.singlePokemon = response
        return response
    }
}