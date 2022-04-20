package com.example.game1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val arguments = intent.extras
        val int = arguments!!["int"].toString()
        val result = findViewById<TextView>(R.id.Result)
        val res = findViewById<Button>(R.id.rest)

        result.text = "Score"+ int

        res.setOnClickListener(){
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
            finish()
        }
    }
}