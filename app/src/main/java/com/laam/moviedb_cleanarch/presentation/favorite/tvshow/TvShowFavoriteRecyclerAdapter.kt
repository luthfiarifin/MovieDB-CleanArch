package com.laam.moviedb_cleanarch.presentation.favorite.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.laam.core.model.TvShowFavoriteEntity
import com.laam.moviedb_cleanarch.R
import com.laam.moviedb_cleanarch.databinding.ItemTvShowBinding

class TvShowFavoriteRecyclerAdapter(private val callback: (Long) -> Unit) :
    PagedListAdapter<TvShowFavoriteEntity, TvShowFavoriteRecyclerAdapter.ViewHolder>(DIFF_CALLBACK) {

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
        getItem(position)?.let { holder.bind(it) }
    }

    inner class ViewHolder(private val binding: ItemTvShowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShowFavoriteEntity: TvShowFavoriteEntity) {
            binding.data = tvShowFavoriteEntity.toTvShowEntity()

            binding.root.setOnClickListener {
                callback(tvShowFavoriteEntity.id)
            }
        }
    }

    companion object {

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowFavoriteEntity>() {

            override fun areItemsTheSame(oldItem: TvShowFavoriteEntity, newItem: TvShowFavoriteEntity): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: TvShowFavoriteEntity, newItem: TvShowFavoriteEntity): Boolean =
                oldItem.id == newItem.id
        }
    }
}