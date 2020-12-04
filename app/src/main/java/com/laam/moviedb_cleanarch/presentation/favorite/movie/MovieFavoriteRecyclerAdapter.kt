package com.laam.moviedb_cleanarch.presentation.favorite.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.laam.core.model.MovieFavoriteEntity
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.ItemMovieBinding

class MovieFavoriteRecyclerAdapter(private val callback: (Long) -> Unit) :
    PagedListAdapter<MovieFavoriteEntity, MovieFavoriteRecyclerAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieFavoriteEntity: MovieFavoriteEntity) {
            binding.data = movieFavoriteEntity.toMovieEntity()

            binding.root.setOnClickListener {
                callback(movieFavoriteEntity.id)
            }
        }
    }

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieFavoriteEntity>() {

            override fun areItemsTheSame(oldItem: MovieFavoriteEntity, newItem: MovieFavoriteEntity): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: MovieFavoriteEntity, newItem: MovieFavoriteEntity): Boolean =
                oldItem.id == newItem.id
        }
    }
}