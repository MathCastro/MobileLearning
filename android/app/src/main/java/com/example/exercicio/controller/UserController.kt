package com.example.exercicio.controller

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.example.exercicio.R
import com.example.exercicio.model.UserBO
import com.example.exercicio.repository.UserRepository

class UserController {

    var user: UserBO? = null

    fun login(context: Context, user: UserBO): Boolean {
        val dbHandler = UserRepository(context, null, null, 1)
        this.user = dbHandler.findUser(user)

        return this.user != null
    }

    fun putLoggedUser(email: String, activity: AppCompatActivity) {
        val sharedPref = activity?.getSharedPreferences(
            activity.getString(R.string.shared_pref), Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString("login", email)
            commit()
        }
    }

    fun getLoggedUser(activity: AppCompatActivity): String? {
        val sharedPref = activity?.getSharedPreferences(
            activity.getString(R.string.shared_pref), Context.MODE_PRIVATE) ?: return null
        return sharedPref.getString("login", "notFound")
    }
}