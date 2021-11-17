package com.awzeus.openpokedex.data.mockDataSource

import com.awzeus.openpokedex.domain.model.PokemonHistoryModel

class PokemonHistoryDataSource {
    companion object {

        fun getPokeHistory(position: Int) : PokemonHistoryModel {
            return pokemonList[position]
        }

        fun getAllPokeHistory(): List<PokemonHistoryModel>{
            return pokemonList
        }

        private val pokemonList = listOf<PokemonHistoryModel>(
            PokemonHistoryModel(
                name = "Pikachu",
                number = 35
            ),
            PokemonHistoryModel(
                "Ditto",
                132
            ),
            PokemonHistoryModel(
                name = "Charizard",
                number = 6
            ),
            PokemonHistoryModel(
                name = "Bulbasaur",
                number = 1
            ),
            PokemonHistoryModel(
                name = "Psyduck",
                number = 90
            )
        )
    }
}