package com.example.game1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Menugame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menugame)

            val start = findViewById<ImageView>(R.id.start)
        val exit = findViewById<ImageView>(R.id.Exit)

        start.setOnClickListener() {
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
            finish()
        }
            exit.setOnClickListener(){
               finish()
            }

    }
}