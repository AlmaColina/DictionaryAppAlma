package com.example.newproject_dictionaryaudio

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val songTitleTextView: TextView = itemView.findViewById(R.id.songTitle)
    private val singerNameTextView: TextView = itemView.findViewById(R.id.singerName)

    fun bind(song: Song) {
        songTitleTextView.text = song.songTitle
        singerNameTextView.text = song.singerName
    }
}