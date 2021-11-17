package com.awzeus.openpokedex.domain

import com.awzeus.openpokedex.data.remote.model.PokemonEntry
import com.awzeus.openpokedex.data.repository.PokemonRepository

class GetRandomPokemon {
    private val repository = PokemonRepository()
    suspend operator fun invoke(): List<PokemonEntry>? = repository.getTenPokemon()
}