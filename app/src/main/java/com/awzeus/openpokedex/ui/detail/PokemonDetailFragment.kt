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
import com.awzeus.openpokedex.databinding.FragmentPokemonDetailBinding
import com.awzeus.openpokedex.domain.model.Pokemon
import com.awzeus.openpokedex.ui.util.BackgroundHelper
import com.squareup.picasso.Picasso


class PokemonDetailFragment : DialogFragment() {
    private lateinit var binding : FragmentPokemonDetailBinding
    private lateinit var detailPokemon : Pokemon
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailPokemon = arguments?.getSerializable("pokemon_arg") as Pokemon

        binding.vPokemonDetailColoredBackground.setBackgroundColor(ContextCompat.getColor(view.context,BackgroundHelper().getColorForType(detailPokemon.type)))
        binding.tvPokemonDetailName.text = detailPokemon.name.replaceFirstChar { it.uppercase() }
        binding.tvPokemonDetailNumber.text = "# ${detailPokemon.id}"
        binding.tvPokemonDetailType.text = detailPokemon.type.replaceFirstChar { it.uppercase() }
        binding.tvPokemonDetailHpValue.text = detailPokemon.hp.toString()
        binding.tvPokemonDetailDefenseValue.text = detailPokemon.defense.toString()
        binding.tvPokemonDetailSpecialDefenseValue.text = detailPokemon.specialDefense.toString()
        binding.tvPokemonDetailAttackValue.text = detailPokemon.attack.toString()
        binding.tvPokemonDetailSpecialAttackValue.text = detailPokemon.specialAttack.toString()
        binding.tvPokemonDetailSpeedValue.text = detailPokemon.speed.toString()
        Picasso.get().load(detailPokemon.imageUrl).into(binding.ivPokemonDetailPokemonImage)

        binding.vPokemonDetailClose.setOnClickListener {
             activity?.supportFragmentManager?.popBackStack()
        }

    }
}