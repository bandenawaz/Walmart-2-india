package com.example.userprofilemanagement

import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


data class UserProfile(val userName: String, val email:  String)

class UserProfileAdapter(private val userList: List<UserProfile>) : RecyclerView.Adapter<UserProfileAdapter.UserProfileViewHolder>() {

    class UserProfileViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val userNameTextView: TextView = itemView.findViewById(R.id.textViewUserName)
        val emailTextView: TextView = itemView.findViewById(R.id.textViewEmail)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserProfileViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_profile, parent, false)
        return UserProfileViewHolder(view)
    }

    override fun getItemCount(): Int {

        return userList.size
    }

    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) {

        val userProfile = userList[position]
        holder.userNameTextView.text = userProfile.userName
        holder.emailTextView.text = userProfile.email
    }
}