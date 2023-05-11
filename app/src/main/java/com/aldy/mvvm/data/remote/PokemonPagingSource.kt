package com.aldy.mvvm.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aldy.mvvm.data.remote.network.ApiServices
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE = 1
private const val PAGING_SIZE = 20

class PokemonPagingSource(
    private val apiServices: ApiServices
    ): PagingSource<Int, Pokemon>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        return try {
            val position = params.key ?: STARTING_PAGE
            val offset = position * PAGING_SIZE
            val response: PokemonResponse = apiServices.getPokemonList(PAGING_SIZE, offset)
            val pokemonList: List<Pokemon> = response.results

            LoadResult.Page(
                data = pokemonList,
                prevKey = if (position == STARTING_PAGE) null else position-1,
                nextKey = if (pokemonList.isEmpty()) null else position+1
            )
        } catch (e: IOException){
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

}