package com.ml.challengeml.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ml.challengeml.R

class SplashScreenActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash_screen)
        startActivity(Intent(this,MainActivity::class.java))
        finish()


    }
}