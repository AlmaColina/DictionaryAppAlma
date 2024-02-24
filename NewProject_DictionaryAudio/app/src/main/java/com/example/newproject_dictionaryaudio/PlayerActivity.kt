package com.example.newproject_dictionaryaudio

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class PlayerActivity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val songTitle = intent.getStringExtra("songTitle")
        val singerName = intent.getStringExtra("singerName")
        val songMp3 = intent.getIntExtra("songMp3", 0)

        val songTitleTextView: TextView = findViewById(R.id.songTitle)
        val singerNameTextView: TextView = findViewById(R.id.singerName)

        songTitleTextView.text = songTitle
        singerNameTextView.text = singerName

        mediaPlayer = MediaPlayer.create(this, songMp3)

        val playButton: ExtendedFloatingActionButton = findViewById(R.id.playButton)
        val pauseButton: ExtendedFloatingActionButton = findViewById(R.id.pauseButton)
        val stopButton: ExtendedFloatingActionButton = findViewById(R.id.stopButton)

        playButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start() // Reproducir la canción
            }
        }

        pauseButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause() // Pausar la reproducción
            }
        }

        stopButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop() // Detener la reproducción
                mediaPlayer.prepare()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}