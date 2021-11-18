package com.example.marketplace

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private var edt_username: EditText? = null
    private var edt_password: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Analytics Event
        val analytics: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        edt_username = findViewById(R.id.edt_username)
        edt_password = findViewById(R.id.edt_password)
        // Obtain the FirebaseAnalytics instance.
        title = resources.getString(R.string.test_login)

        session()

    }

    override fun onStart() {
        super.onStart()

        val prefs =
            getSharedPreferences(resources.getString(R.string.preds_file), Context.MODE_PRIVATE)
        val email = prefs.getString("email", null)
        val provider = prefs.getString("provider", null)

        if (email == null && provider == null) {
            var loginLayout = findViewById<LinearLayout>(R.id.loginLayout);
            loginLayout.visibility = View.VISIBLE
        }


    }

    private fun session() {
        val prefs =
            getSharedPreferences(resources.getString(R.string.preds_file), Context.MODE_PRIVATE)
        val email = prefs.getString("email", null)
        val provider = prefs.getString("provider", null)

        if (email != null && provider != null) {
            var loginLayout = findViewById<LinearLayout>(R.id.loginLayout);
            loginLayout.visibility = View.INVISIBLE

            showHome(email, ProviderType.valueOf(provider))
        }

    }

    private fun showHome(username: String, provider: ProviderType) {

        val homeIntent = Intent(this, WelcomeActivity::class.java).apply {
            putExtra("email", username)
            putExtra("provider", provider.toString())
        }

        startActivity(homeIntent)

        getToast(resources.getString(R.string.test_welcome));
    }

    private fun getToast(message: String) {
        Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_LONG
        ).show();
    }


    fun onGetIn(view: android.view.View) {
        var user: String = edt_username!!.text.toString()
        var password: String = edt_password!!.text.toString()

        if (user.isNotEmpty() && password.isNotEmpty()) {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(user, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(user, ProviderType.BASIC)
                    } else {
                        getToast(resources.getString(R.string.test_errorAuth));
                    }
                }

        } else {
            getToast(resources.getString(R.string.test_errorlogin));
        }
    }

        fun onReturn(view: android.view.View) {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
        }

        fun onRegistrar(view: android.view.View) {
            val registrarIntent = Intent(this, RegisterActivity::class.java)
            startActivity(registrarIntent)
            getToast(resources.getString(R.string.test_register));
        }


}