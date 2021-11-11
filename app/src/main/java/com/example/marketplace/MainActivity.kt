package com.example.marketplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onLogin(view: android.view.View) {
        val intento = Intent(this, LoginActivity::class.java)
        startActivity(intento)
    }
    fun onRegister(view: android.view.View) {
        val intento = Intent(this, RegisterActivity::class.java)
        startActivity(intento)
    }
    fun onAbout(view: android.view.View) {
        val intento = Intent(this, AboutUsActivity::class.java)
        startActivity(intento)
    }
}