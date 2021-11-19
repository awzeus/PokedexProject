package com.awzeus.openpokedex.ui.util

import com.awzeus.openpokedex.data.remote.model.PokemonEntry
import com.awzeus.openpokedex.domain.model.Pokemon

class ConvertPokemon {
    fun convertEntrytoPokemon(pokemon: PokemonEntry): Pokemon{
        return Pokemon(
            pokemon.id,
            pokemon.name,
            pokemon.types.get(0).type.name,
            pokemon.stats.get(0).base_stat,
            pokemon.stats.get(1).base_stat,
            pokemon.stats.get(2).base_stat,
            pokemon.stats.get(3).base_stat,
            pokemon.stats.get(4).base_stat,
            pokemon.stats.get(5).base_stat,
            pokemon.sprites.front_default
        )
    }
}