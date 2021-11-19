package com.awzeus.openpokedex.ui.discover


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awzeus.openpokedex.data.remote.model.PokemonEntry
import com.awzeus.openpokedex.databinding.ItemPokemonBinding
import com.awzeus.openpokedex.ui.util.BackgroundHelper
import com.awzeus.openpokedex.ui.util.ConvertPokemon
import com.awzeus.openpokedex.ui.util.PokemonListCallback
import com.squareup.picasso.Picasso

class DiscoverAdapter (private val pokemon: List<PokemonEntry>,
                       private val callBack: PokemonListCallback): RecyclerView.Adapter<DiscoverAdapter.PokemonHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PokemonHolder(binding,callBack)
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        holder.render(pokemon[position])
    }

    override fun getItemCount(): Int = pokemon.size


    class PokemonHolder(val binding: ItemPokemonBinding, val callBack: PokemonListCallback) : RecyclerView.ViewHolder(binding.root){
        fun render(pokemon: PokemonEntry){
            binding.tvPokemonEntryName.text = pokemon.name.replaceFirstChar { it.uppercaseChar() }
            binding.tvPokemonEntryNumber.text = "# ${pokemon.id}"
            binding.tvPokemonEntryType.text = pokemon.types.get(0).type.name.replaceFirstChar { it.uppercase() }
            Picasso.get().load(pokemon.sprites.front_default).into(binding.tvPokemonEntryImage)
            binding.clColoredBackground.setBackgroundResource(BackgroundHelper().getDrawableForType(pokemon.types.get(0).type.name))
            binding.root.setOnClickListener {
                callBack.onClick(ConvertPokemon().convertEntrytoPokemon(pokemon))
            }
        }

    }
}