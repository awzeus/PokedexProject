package com.awzeus.openpokedex.domain.model

import com.awzeus.openpokedex.data.local.model.PokemonEntity
import java.io.Serializable

class Pokemon(
    var id: Int,
    var name: String,
    var type: String,
    var hp: Int,
    var attack: Int,
    var specialAttack: Int,
    var defense: Int,
    var specialDefense: Int,
    var speed: Int,
    var imageUrl: String
) : Serializable

fun Pokemon.toEntity() = PokemonEntity(
    id, name, type, hp, attack, specialAttack, defense, specialDefense, speed, imageUrl
)