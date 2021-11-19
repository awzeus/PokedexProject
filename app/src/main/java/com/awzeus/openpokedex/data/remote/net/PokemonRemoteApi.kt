package com.awzeus.openpokedex.data.remote.net

import com.awzeus.openpokedex.data.remote.model.PokemonEntry
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonRemoteApi {
    @GET("pokemon/{id}")
    suspend fun getPokemonByCriteria(@Path("id") id: String): Response<PokemonEntry>
}