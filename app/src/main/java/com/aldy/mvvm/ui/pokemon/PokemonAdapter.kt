package com.aldy.mvvm.ui.pokemon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aldy.mvvm.R
import com.aldy.mvvm.data.remote.Pokemon
import com.aldy.mvvm.databinding.ItemPokemonBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class PokemonAdapter: PagingDataAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(COMPARATOR) {

    inner class PokemonViewHolder(private val binding: ItemPokemonBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun bind(pokemon: Pokemon) {
                with(binding) {
                    Glide.with(itemView)
                        .load(pokemon.getImageUrl())
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.ic_error)
                        .into(image)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null){
            holder.bind(currentItem)
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Pokemon>(){
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean =
                oldItem == newItem

        }
    }
}