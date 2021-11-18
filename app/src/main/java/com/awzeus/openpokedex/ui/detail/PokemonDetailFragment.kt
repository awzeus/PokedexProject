package com.awzeus.openpokedex.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.awzeus.openpokedex.R
import com.awzeus.openpokedex.domain.model.Pokemon
import com.awzeus.openpokedex.ui.util.BackgroundHelper
import com.squareup.picasso.Picasso


class PokemonDetailFragment : DialogFragment() {
    //TODO binding
    private lateinit var detailPokemon : Pokemon
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
                return inflater.inflate(R.layout.fragment_pokemon_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailPokemon = arguments?.getSerializable("pokemon_arg") as Pokemon
        val backgroundView = view?.findViewById<View>(R.id.v_pokemon_detail_colored_background)
        val name = view?.findViewById<TextView>(R.id.tv_pokemon_detail_name)
        val id = view?.findViewById<TextView>(R.id.tv_pokemon_detail_number)
        val type = view?.findViewById<TextView>(R.id.tv_pokemon_detail_type)
        val hp = view?.findViewById<TextView>(R.id.tv_pokemon_detail_hp_value)
        val attack = view?.findViewById<TextView>(R.id.tv_pokemon_detail_attack_value)
        val specialAttack = view?.findViewById<TextView>(R.id.tv_pokemon_detail_special_attack_value)
        val defense = view?.findViewById<TextView>(R.id.tv_pokemon_detail_defense_value)
        val specialDefense = view?.findViewById<TextView>(R.id.tv_pokemon_detail_special_defense_value)
        val speed = view?.findViewById<TextView>(R.id.tv_pokemon_detail_speed_value)
        val img = view?.findViewById<ImageView>(R.id.iv_pokemon_detail_pokemon_image)

        backgroundView?.setBackgroundColor(ContextCompat.getColor(view.context,BackgroundHelper().getColorForType(detailPokemon.type)))
        name?.setText(detailPokemon.name.replaceFirstChar { it.uppercase() })
        id?.setText("#${detailPokemon.id}")
        type?.setText(detailPokemon.type.replaceFirstChar { it.uppercase() })
        hp?.setText(detailPokemon.hp.toString())
        attack?.setText(detailPokemon.attack.toString())
        specialAttack?.setText(detailPokemon.specialAttack.toString())
        defense?.setText(detailPokemon.defense.toString())
        specialDefense?.setText(detailPokemon.specialDefense.toString())
        speed?.setText(detailPokemon.speed.toString())
        Picasso.get().load(detailPokemon.imageUrl).into(img)
    }
}