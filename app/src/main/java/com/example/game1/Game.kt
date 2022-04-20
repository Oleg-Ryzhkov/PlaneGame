package com.example.game1

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.translationMatrix

class Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val plane = findViewById<ImageView>(R.id.plane)
        val coin = findViewById<ImageView>(R.id.coin)
        val rok = findViewById<ImageView>(R.id.rok)
        val coin2 = findViewById<ImageView>(R.id.coin2)
        val rok2 = findViewById<ImageView>(R.id.rok2)
        val textscore = findViewById<TextView>(R.id.score)
        val right = findViewById<ImageView>(R.id.right)
        val left = findViewById<ImageView>(R.id.left)
        var schet = 0
        val textresult = "Score: "
        var stop = 0


        val position = arrayOf(-400, -200, 0, 200, 400)
        position.shuffle()

        fun roklounch() {
            rok.animate().translationY(-800f).translationX(position[0].toFloat()).setDuration(0)
                .withEndAction() {
                    rok.animate().translationYBy(3000f).setDuration(5000).withEndAction() {
                        position.shuffle()
                        roklounch()
                    }

                }
        }

        fun coinlounch() {
            coin.animate().alpha(1f)
            coin.animate().translationY(-1000f).translationX(position[1].toFloat()).setDuration(0)
                .withEndAction() {
                    coin.animate().translationYBy(3000f).setDuration(5000).withEndAction() {
                        coinlounch()
                    }

                }
        }
        fun coinlounch2() {
            coin2.animate().alpha(1f)
            coin2.animate().translationY(-1000f).translationX(position[2].toFloat()).setDuration(0)
                .withEndAction() {
                    coin2.animate().translationYBy(3000f).setDuration(5000).withEndAction() {
                        coinlounch2()
                    }

                }
        }

        fun roklounch2() {
            rok2.animate().translationY(-800f).translationX(position[3].toFloat()).setDuration(0)
                .withEndAction() {
                    rok2.animate().translationYBy(3000f).setDuration(5000).withEndAction() {
                        roklounch2()
                    }

                }
        }

        coin2.animate().translationY(-1000f).translationX(position[2].toFloat()).setDuration(0)
        rok2.animate().translationY(-800f).translationX(position[3].toFloat()).setDuration(0)
        Handler().postDelayed({
            coinlounch2()
        },1000)
        Handler().postDelayed({
            roklounch2()
        },2000)
        roklounch()
        coinlounch()



        left.setOnClickListener() {
            left.setClickable(false)
            right.setClickable(false)
            plane.animate().translationXBy(-200f).setDuration(500).withEndAction() {
                if (plane.translationX <= -350f)

                {
                    left.setClickable(false)
                }
                else
                left.setClickable(true)
                right.setClickable(true)
            }
        }
        right.setOnClickListener() {
            right.setClickable(false)
            left.setClickable(false)
            plane.animate().translationXBy(200f).setDuration(500).withEndAction() {
                if (plane.translationX >= 350f)

                {
                    right.setClickable(false)
                }
                else
                right.setClickable(true)
                left.setClickable(true)
            }
        }


        val intent = Intent(this, Result::class.java)




        val handler = Handler()
        handler.post(object : Runnable {
            override fun run() {
                val planerect = Rect()
                plane.getHitRect(planerect)

                val rokrect = Rect()
                rok.getHitRect(rokrect)

                val coinrect = Rect()
                coin.getHitRect(coinrect)

                val rokrect2 = Rect()
                rok2.getHitRect(rokrect2)

                val coinrect2 = Rect()
                coin2.getHitRect(coinrect2)




                fun logic() {
                if (Rect.intersects(planerect, rokrect)) {
                    intent.putExtra("int", "" + schet);
                    rok.animate().alpha(0f).setDuration(0)
                    rok2.animate().alpha(0f).setDuration(0)
                    coin.animate().alpha(0f).setDuration(0)
                    coin2.animate().alpha(0f).setDuration(0)
                    plane.setImageResource(R.drawable.bah)
                    coin.animate().translationY(-1000f).translationX(position[2].toFloat()).setDuration(0)
                    coin2.animate().translationY(-1000f).translationX(position[2].toFloat()).setDuration(0)
                    stop = 1
                    Handler().postDelayed({
                        finish()
                        startActivity(intent)
                    },2000)

                }
                    if (Rect.intersects(planerect, rokrect2)) {
                        intent.putExtra("int", "" + schet)
                        rok.animate().alpha(0f).setDuration(0)
                        rok2.animate().alpha(0f).setDuration(0)
                        coin.animate().alpha(0f).setDuration(0)
                        coin2.animate().alpha(0f).setDuration(0)
                        plane.setImageResource(R.drawable.bah)
                        coin.animate().translationY(-1000f).translationX(position[2].toFloat()).setDuration(0)
                        coin2.animate().translationY(-1000f).translationX(position[2].toFloat()).setDuration(0)
                        stop = 1
                        Handler().postDelayed({
                            finish()
                            startActivity(intent)
                        },2000)

                    }

                if (Rect.intersects(planerect, coinrect)) {
                    schet ++
                    textscore.text = textresult + schet
                    coin.animate().alpha(0f).setDuration(0)

                }
                    if (Rect.intersects(planerect, coinrect2)) {
                        schet ++
                        textscore.text = textresult + schet
                        coin2.animate().alpha(0f).setDuration(0)

                    }
            }
                logic()
                if (stop == 1){
                    left.setClickable(false)
                    right.setClickable(false)
                }
            handler.postDelayed(this::run, 500)

        }
        })

    }
}


