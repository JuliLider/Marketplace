package com.example.marketplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    private var edt_username: EditText? = null
    private var edt_password: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt_username = findViewById(R.id.edt_username)
        edt_password = findViewById(R.id.edt_password)
    }

    fun onReturn(view: android.view.View) {
        val intento = Intent(this, MainActivity::class.java)
        startActivity(intento)
    }

    fun onGetIn(view: android.view.View) {
        if (edt_username!!.text.toString()=="juli110@hotmail.es"){
            if (edt_password!!.text.toString()=="12345"){

                val intento = Intent(this, WelcomeActivity::class.java)
                startActivity(intento)

            }
        }

    }
}