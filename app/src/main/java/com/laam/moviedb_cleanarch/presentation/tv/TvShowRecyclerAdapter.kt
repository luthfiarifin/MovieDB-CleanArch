package com.laam.moviedb_cleanarch.presentation.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.laam.core.model.TvShow
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.ItemTvShowBinding

class TvShowRecyclerAdapter : ListAdapter<TvShow, TvShowRecyclerAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_tv_show,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: TvShow) {
            binding.data = movie
        }
    }

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShow>() {

            override fun areItemsTheSame(oldItem: TvShow, newItem: TvShow): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: TvShow, newItem: TvShow): Boolean =
                oldItem.id == newItem.id
        }
    }
}