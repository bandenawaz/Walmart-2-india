package com.example.userprofilemanagement

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


//        findViewById<Button>(R.id.buttonOpenUserProfile).setOnClickListener {
//            //write a method to navigate or pen the User profile Fragment
//            openUserProfileFragment(UserProfileFragment())
//        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_profile -> {
                Log.d("MenuClick", "Add Profile Clicked")
                openUserProfileFragment(UserProfileFragment())
                true
            }
            R.id.action_settings -> {
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun openUserProfileFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }


}