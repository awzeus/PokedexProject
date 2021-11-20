package com.awzeus.openpokedex.data.local.database

import androidx.room.*
import com.awzeus.openpokedex.data.local.model.PokemonEntity

@Dao
interface PokemonDao {
    @Query("SELECT * FROM $TABLE_POKEMON")
    suspend fun getPokemonFromPokedex(): List<PokemonEntity>

    @Delete
    suspend fun delete(pokemon: PokemonEntity) : Int

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun save(pokemon:PokemonEntity)
}