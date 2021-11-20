package com.awzeus.openpokedex.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.awzeus.openpokedex.data.local.database.TABLE_POKEMON
import com.awzeus.openpokedex.domain.model.Pokemon

@Entity(tableName = TABLE_POKEMON)
data class PokemonEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val type: String,
    val hp: Int,
    val attack: Int,
    val specialAttack: Int,
    val defense: Int,
    val specialDefense: Int,
    val speed: Int,
    val imageUrl: String
)

fun PokemonEntity.toPokemon() = Pokemon(
    id,
    name,
    type,
    hp,
    attack,
    specialAttack,
    defense,
    specialDefense,
    speed,
    imageUrl
)
