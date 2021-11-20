package com.awzeus.openpokedex.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.awzeus.openpokedex.R
import com.awzeus.openpokedex.databinding.FragmentPokemonDetailBinding
import com.awzeus.openpokedex.domain.model.Pokemon
import com.awzeus.openpokedex.ui.util.BackgroundHelper
import com.squareup.picasso.Picasso


class PokemonDetailFragment : DialogFragment() {
    private lateinit var binding : FragmentPokemonDetailBinding
    private lateinit var detailPokemon : Pokemon
    private lateinit var viewModel: PokemonDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonDetailBinding.inflate(inflater,container,false)
        val pokemonFactory = PokemonDetailViewModel.PokemonFactory()
        viewModel = ViewModelProvider(this,pokemonFactory).get(PokemonDetailViewModel::class.java)
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
            activity?.onBackPressed()
        }

        viewModel.getPokedexIds()
        viewModel.savedIds.observe(viewLifecycleOwner,{ listOfSavedIds ->
            if(listOfSavedIds.contains(detailPokemon.id)){
                binding.vPokemonDetailAction.setBackgroundResource(R.drawable.ic_delete)
                binding.vPokemonDetailAction.setOnClickListener {
                    viewModel.deletePokemon(detailPokemon)
                    binding.vPokemonDetailAction.setBackgroundResource(R.drawable.ic_checkmark)
                    binding.vPokemonDetailAction.isClickable = false
                }
            }else{
                binding.vPokemonDetailAction.setBackgroundResource(R.drawable.ic_save)
                binding.vPokemonDetailAction.setOnClickListener {
                    viewModel.addToPokedex(detailPokemon)
                    binding.vPokemonDetailAction.setBackgroundResource(R.drawable.ic_checkmark)
                    binding.vPokemonDetailAction.isClickable = false
                }
            }
        })

    }
}