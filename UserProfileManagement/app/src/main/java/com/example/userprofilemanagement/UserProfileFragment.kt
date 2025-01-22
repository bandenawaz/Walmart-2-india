package com.example.userprofilemanagement

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class UserProfileFragment : Fragment() {

    private val userList = mutableListOf<UserProfile>()
    private lateinit var adapter: UserProfileAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user_profile, container, false)
        val etUserName = view.findViewById<EditText>(R.id.editTextUserName)
        val etEmail = view.findViewById<EditText>(R.id.editTextEmail)

        val saveButton = view.findViewById<Button>(R.id.buttonSave)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvUserProfiles)

        //get Shared Preference instance
        val sharedPreferences = requireContext().getSharedPreferences("UerProfilePrefs", Context.MODE_PRIVATE)

        //let load saved user profile data
        val savedUsername = sharedPreferences.getString("username", "")
        val savedEmail = sharedPreferences.getString("email", "")

        etUserName.setText(savedUsername)
        etEmail.setText(savedEmail)

        adapter = UserProfileAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        //handle save click event
        saveButton.setOnClickListener {
            val username = etUserName.text.toString()
            val email = etEmail.text.toString()

            //lets perform some validation
            if (username.isNotEmpty() && email.isNotEmpty()) {
                saveUserProfileData(username, email, sharedPreferences)
            }else{
                Toast.makeText(context, "Please enter both username and email", Toast.LENGTH_LONG).show()
            }

            etUserName.setText(null)
            etEmail.setText(null)
        }


        return view
    }


    private fun saveUserProfileData(username: String, email: String, sharedPreferences: SharedPreferences) {

        //Save to shared Preferences
        val editor = sharedPreferences.edit()
        editor.putString("username", username)
        editor.putString("email", email)
        editor.apply()

        //For just showing message that is data saved, i will just toast a message
        val userProfile = UserProfile(username, email)
        userList.add(userProfile)
        adapter.notifyDataSetChanged()
        Toast.makeText(context, "Profile saved", Toast.LENGTH_LONG).show()

    }


}