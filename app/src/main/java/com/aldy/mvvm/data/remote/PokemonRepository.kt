package com.aldy.mvvm.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.aldy.mvvm.data.remote.network.ApiServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(private val apiServices: ApiServices) {
    fun getPokemonList() =
        Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {PokemonPagingSource(apiServices)}
        ).liveData
}