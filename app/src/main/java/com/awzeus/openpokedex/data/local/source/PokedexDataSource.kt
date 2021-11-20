package com.awzeus.openpokedex.data.local.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.awzeus.openpokedex.data.local.repository.PokedexRepository
import com.awzeus.openpokedex.data.local.database.PokemonDao
import com.awzeus.openpokedex.data.local.model.toPokemon
import com.awzeus.openpokedex.domain.model.Pokemon
import com.awzeus.openpokedex.domain.model.toEntity

class PokedexDataSource ( private val pokemonDao: PokemonDao): PokedexRepository {
    override suspend fun getMyPokemon(): LiveData<List<Pokemon>> {
        return MutableLiveData(pokemonDao.getPokemonFromPokedex().map { it.toPokemon() })
    }

    override suspend fun add(pokemon: Pokemon) {
        pokemonDao.save(pokemon.toEntity())
    }

    override suspend fun remove(pokemon: Pokemon) {
        pokemonDao.delete(pokemon.toEntity())
    }
}