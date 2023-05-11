package com.aldy.mvvm.data.remote

import com.google.gson.annotations.SerializedName

data class PokemonResponse (
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String? = null,
    @SerializedName("previous") val previous: String? = null,
    @SerializedName("results") val results: List<Pokemon>
)