package com.awzeus.openpokedex.domain.model

import java.io.Serializable

class Pokemon(
    var id: Int,
    var name: String,
    var type: String,
    val hp: Int,
    var attack: Int,
    var specialAttack: Int,
    var defense: Int,
    var specialDefense: Int,
    var speed: Int,
    var imageUrl: String
) : Serializable
