package com.example.marketplace

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.marketplace.databinding.ActivityWelcomeBinding
//import com.example.marketplace.databinding.ActivityHomeBinding
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth

enum class  ProviderType{
    BASIC,
    GOOGLE,
    FACEBOOK
}

class WelcomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityWelcomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_welcome)

        setSupportActionBar(findViewById(R.id.my_toolbar))

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->

        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view_tag) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home,R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //setup Login
        title=resources.getString(R.string.text_Home)
        val bundle =intent.extras
        val email=bundle?.getString("email")
        val provider=bundle?.getString("provider")

        navView.getHeaderView(0).findViewById<TextView>(R.id.emailTextView).text = email;
        navView.getHeaderView(0).findViewById<TextView>(R.id.providerTextView).text=provider;

        //Save Data
        val prefs=getSharedPreferences(resources.getString(R.string.preds_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email",email)
        prefs.putString("provider",provider)
        prefs.apply()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_welcome_activity, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view_tag) as NavHostFragment
        val navController = navHostFragment.navController

        return navController.navigateUp(appBarConfiguration)  || super.onSupportNavigateUp()
    }

    fun onSignoff(view: android.view.View) {

        //Delete Data
        val prefs=getSharedPreferences(resources.getString(R.string.preds_file), Context.MODE_PRIVATE).edit()
        prefs.clear()
        prefs.apply()

        val navView: NavigationView = binding.navView
        if(navView.findViewById<TextView>(R.id.providerTextView).text == ProviderType.FACEBOOK.name){
            LoginManager.getInstance().logOut()
        }

        FirebaseAuth.getInstance().signOut()
        onBackPressed()
    }

    }
