package com.aldy.mvvm.data.remote.network

import com.aldy.mvvm.data.remote.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonResponse
}