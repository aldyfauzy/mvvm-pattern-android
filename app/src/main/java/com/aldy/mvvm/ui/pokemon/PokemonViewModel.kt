package com.aldy.mvvm.ui.pokemon

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aldy.mvvm.data.remote.Pokemon
import com.aldy.mvvm.data.remote.PokemonRepository

class PokemonViewModel @ViewModelInject constructor(private val repository: PokemonRepository) :
    ViewModel() {
    val pokemonList: LiveData<PagingData<Pokemon>> = repository.getPokemonList().cachedIn(viewModelScope)
}