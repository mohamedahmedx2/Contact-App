package com.example.contacts

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper())
            .postDelayed(
                {
                    startHomeActivity()
                },
                2000
            )


    }

    private fun startHomeActivity() {
        val intent = Intent(this, ContactActivity::class.java)
        startActivity(intent)
        finish()
    }
}