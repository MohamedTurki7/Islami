package com.route.islamii.ui.chapterDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.islamii.R

class VersesRecyclerAdapter(val versesList: List<String>) :
    RecyclerView.Adapter<VersesRecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val versesContent: TextView = itemView.findViewById(R.id.content)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_verse, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = versesList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content = versesList[position]
        holder.versesContent.text = "$content(${position + 1})"
    }
}