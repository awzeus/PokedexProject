package com.awzeus.openpokedex.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.awzeus.openpokedex.data.local.model.PokemonEntity

const val DATABASE_VERSION = 1
const val TABLE_POKEMON = "pokemon"
const val DATABASE_NAME = "pokedex.sqlite"

@Database(
    entities = [PokemonEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase(){
    abstract fun pokemonDao(): PokemonDao
}