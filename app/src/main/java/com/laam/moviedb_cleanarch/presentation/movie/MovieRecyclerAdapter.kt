package com.laam.moviedb_cleanarch.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.laam.core.model.Movie
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.ItemMovieBinding
import com.laam.moviedb_cleanarch.framework.model.MovieEntity

class MovieRecyclerAdapter : ListAdapter<MovieEntity, MovieRecyclerAdapter.ViewHolder>(DIFF_CALLBACK) {

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
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieEntity) {
            binding.data = movie
        }
    }

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {

            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                oldItem.id == newItem.id
        }
    }
}