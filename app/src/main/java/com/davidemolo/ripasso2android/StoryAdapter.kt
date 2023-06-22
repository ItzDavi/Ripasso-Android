package com.davidemolo.ripasso2android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView

class StoryAdapter(private val list: List<StoryViewModel>) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val author: TextView = itemView.findViewById(R.id.story_author)
        val image: ShapeableImageView = itemView.findViewById(R.id.story_imageview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        return StoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.story_item, parent, false))
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.author.text = list[position].getStoryAuthor()

        Glide.with(holder.itemView).load(list[position].getStoryImage()).centerCrop().into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}