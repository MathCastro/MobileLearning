package com.example.exercicio.controller

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.example.exercicio.model.CalendarBO
import com.example.exercicio.model.UserBO
import com.example.exercicio.repository.UserRepository

class CalendarController {

    var userController = UserController()

    fun addCalendar(context: Context, dateTime: String, activity: AppCompatActivity) {
        var userRepository = UserRepository(context, null, null, 1)
        var user = userRepository.findUserByEmail(userController.getLoggedUser(activity)!!)
        val dbHandler = UserRepository(context, null, null, 1)
        var calendar = CalendarBO(dateTime, user?.id!!)
        dbHandler.addCalendar(CalendarBO(dateTime, user?.id!!))
    }
}