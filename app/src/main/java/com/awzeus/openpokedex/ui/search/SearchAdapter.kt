package com.awzeus.openpokedex.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awzeus.openpokedex.databinding.ItemHistoryBinding
import com.awzeus.openpokedex.domain.model.Pokemon
import com.awzeus.openpokedex.ui.util.PokemonListCallback

class SearchAdapter(private val listHistory: MutableList<Pokemon>, private val callBack: PokemonListCallback): RecyclerView.Adapter<SearchAdapter.HistoryHolder>()  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HistoryHolder(binding,callBack)
    }

    override fun onBindViewHolder(holder: HistoryHolder, position: Int) {
        holder.render(listHistory[position])
    }

    override fun getItemCount(): Int = listHistory.size

    class HistoryHolder(val binding: ItemHistoryBinding, val callBack: PokemonListCallback) : RecyclerView.ViewHolder(binding.root){
        fun render(pokemon: Pokemon){
            binding.tvHistoryEntryName.text = pokemon.name.replaceFirstChar { it.uppercase() }
            binding.tvHistoryEntryNumber.text = "#${pokemon.id}"
            binding.root.setOnClickListener {
                callBack.onClick(pokemon)
            }
        }

    }

}