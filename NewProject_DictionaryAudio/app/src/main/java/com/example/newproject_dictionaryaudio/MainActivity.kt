package com.example.newproject_dictionaryaudio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songs = listOf(
            Song("Love is Back", "Celeste", R.raw.loveisback),
            Song("Water", "Tyla", R.raw.water),
            Song("Now and Then", "The Beatles", R.raw.nowandthen),
            Song("Beautiful Things", "Benson Boone", R.raw.beautifulthings),
            Song("Paint The Town Red", "Doja Cat", R.raw.paintred),
            Song("MELTDOWN", "Travis Scott", R.raw.meltdown),
            Song("On The Low", "Burna Boy", R.raw.onthelow),
            Song("Little Things", "Jorja Smith", R.raw.littlethings),
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = SongAdapter(songs) { song ->
            val intent = Intent(this, PlayerActivity::class.java).apply {
                putExtra("songTitle", song.songTitle)
                putExtra("singerName", song.singerName)
                putExtra("songMp3", song.songMp3)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}