package com.example.exercicio.controller

import android.content.Context
import com.example.exercicio.model.UserBO
import com.example.exercicio.repository.UserRepository

class UserController {

    var user: UserBO? = null

    fun login(context: Context, user: UserBO): Boolean {
        val dbHandler = UserRepository(context, null, null, 1)
        this.user = dbHandler.findUser(user)

        return this.user != null
    }
}