package com.awzeus.openpokedex.data.remote.model

import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject

data class PokemonEntry(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("types")
    val types: List<TypeEntry>,
    @SerializedName("stats")
    val stats: List<StatsEntry>,
    @SerializedName("sprites")
    val sprites: SpriteObject
    )
data class TypeEntry(
    @SerializedName("type")
    val type: TypeName
)
data class TypeName(
    @SerializedName("name")
    val name: String
)
data class StatsEntry(
    @SerializedName("base_stat")
    val base_stat: Int
)
data class SpriteObject(
    @SerializedName("front_default")
    val front_default: String
)
