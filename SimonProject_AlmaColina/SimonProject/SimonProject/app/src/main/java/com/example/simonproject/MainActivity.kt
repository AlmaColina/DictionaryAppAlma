package com.example.simonproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var random = (0..3).random()
        val fourColors = arrayOf("Green", "Yellow", "Blue", "Red")
        val allColors: ArrayList<String> = arrayListOf(fourColors[random])
        val start = findViewById<Button>(R.id.startBtn)
        val activitiesArray = arrayOf(GreenColor::class.java, YellowColor::class.java, BlueColor::class.java, RedColor::class.java)

        //Colores Random
        for(i in 0..3){
            random = (0..3).random()
            allColors.add(fourColors[random])
        }

        //Boton para comenzar
        start.setOnClickListener {
            val intent = Intent(this@MainActivity, activitiesArray[random])
            intent.putStringArrayListExtra("colors", allColors)
            intent.putExtra("count", 0)
            intent.putExtra("score", 0)
            startActivity(intent)
        }
    }
}