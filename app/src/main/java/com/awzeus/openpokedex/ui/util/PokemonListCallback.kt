package com.awzeus.openpokedex.ui.util

import com.awzeus.openpokedex.domain.model.Pokemon

interface PokemonListCallback {
    //fun onClick(book: Book)
    fun onClick(pokemon: Pokemon)
}