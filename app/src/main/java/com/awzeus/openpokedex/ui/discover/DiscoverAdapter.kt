package com.awzeus.openpokedex.ui.discover

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.awzeus.openpokedex.R
import com.awzeus.openpokedex.data.remote.model.PokemonEntry
import com.awzeus.openpokedex.ui.util.BackgroundHelper
import com.squareup.picasso.Picasso

class DiscoverAdapter (val pokemon: List<PokemonEntry>): RecyclerView.Adapter<DiscoverAdapter.PokemonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokemonHolder(layoutInflater.inflate(R.layout.item_pokemon, parent, false))
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.render(pokemon[position])
    }

    override fun getItemCount(): Int = pokemon.size


    class PokemonHolder(val view: View) : RecyclerView.ViewHolder(view){
        fun render(pokemon: PokemonEntry){
            val pokemonName = view.findViewById<TextView>(R.id.tv_pokemon_entry_name)
            val pokemonNumber = view.findViewById<TextView>(R.id.tv_pokemon_entry_number)
            val pokemonType = view.findViewById<TextView>(R.id.tv_pokemon_entry_type)
            val pokemonImage = view.findViewById<ImageView>(R.id.tv_pokemon_entry_image)
            val background = view.findViewById<ConstraintLayout>(R.id.cl_colored_background)
            pokemonName.text = pokemon.name.replaceFirstChar { it.uppercaseChar() }
            pokemonNumber.text = "# ${pokemon.id}"
            pokemonType.text = pokemon.types.get(0).type.name.uppercase()
            Picasso.get().load(pokemon.sprites.front_default).into(pokemonImage)
            background.setBackgroundResource(BackgroundHelper().getDrawableForType(pokemon.types.get(0).type.name))
        }

    }
}