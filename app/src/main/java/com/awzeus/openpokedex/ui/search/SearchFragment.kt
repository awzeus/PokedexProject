package com.awzeus.openpokedex.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.awzeus.openpokedex.R

class SearchFragment : Fragment() {
    private val searchViewModel: SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        val titleSearch: TextView = view.findViewById(R.id.tv_title_search_search)

        searchViewModel.pokemonHistoryModel.observe(viewLifecycleOwner, Observer {
            titleSearch.text = it.name
        })

        titleSearch.setOnClickListener {
            searchViewModel.pokemonHistoryEntry()
        }
        return view
    }
}