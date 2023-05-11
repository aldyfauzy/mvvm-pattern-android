package com.aldy.mvvm.ui.pokemon

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.aldy.mvvm.R
import com.aldy.mvvm.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonFragment : Fragment(R.layout.fragment_main) {
    private val viewModel by viewModels<PokemonViewModel>()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
        val adapter = PokemonAdapter()
        binding.apply {
            rvPokemon.setHasFixedSize(true)
            rvPokemon.adapter = adapter.withLoadStateHeaderAndFooter(
                header = PokemonLoadStateAdapter {adapter.retry()},
                footer = PokemonLoadStateAdapter {adapter.retry()}
            )
        }
        viewModel.pokemonList.observe(viewLifecycleOwner){
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }
}