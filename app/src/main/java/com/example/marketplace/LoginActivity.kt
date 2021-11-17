package com.example.marketplace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private var edt_username: EditText? = null
    private var edt_password: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt_username = findViewById(R.id.edt_username)
        edt_password = findViewById(R.id.edt_password)
        // Obtain the FirebaseAnalytics instance.
    }

    fun onGetIn(view: android.view.View) {
        var user:String=edt_username!!.text.toString()
        var password:String=edt_password!!.text.toString()

        if (user=="juli110@hotmail.es"&&password=="12345"){

                val intento = Intent(this, WelcomeActivity::class.java)
                startActivity(intento)
                Toast.makeText(applicationContext,"welcome",Toast.LENGTH_LONG).show()

            }
            else{
                Toast.makeText(this,"Invalid user name or password",Toast.LENGTH_LONG).show()
            }
        }

    fun onReturn(view: android.view.View) {
        val intento = Intent(this, MainActivity::class.java)
        startActivity(intento)
    }



}