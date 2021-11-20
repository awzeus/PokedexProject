package com.awzeus.openpokedex.data.local.repository

import androidx.lifecycle.LiveData
import com.awzeus.openpokedex.domain.model.Pokemon

interface PokedexRepository {
    suspend fun getMyPokemon(): LiveData<List<Pokemon>>

    suspend fun getFilteredPokemon(query: String): LiveData<List<Pokemon>>

    suspend fun add(pokemon: Pokemon)

    suspend fun remove(pokemon: Pokemon)
}