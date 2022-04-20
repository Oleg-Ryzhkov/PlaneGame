package com.example.game1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    Handler().postDelayed({
        val intent = Intent(this, Menugame::class.java)
        startActivity(intent)
        finish()
    },500) // запуск активити через 5сек
    }
}
