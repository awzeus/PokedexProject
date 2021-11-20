package com.awzeus.openpokedex.data.remote.source

import com.awzeus.openpokedex.data.remote.model.PokemonEntry

class PokemonDataSource {
    companion object{
        var pokemon: List<PokemonEntry> = emptyList()
        var singlePokemon: PokemonEntry? = null
    }
}