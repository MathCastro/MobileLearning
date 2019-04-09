package com.example.exercicio.view

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import com.example.exercicio.R
import com.example.exercicio.controller.CalendarController
import com.example.exercicio.controller.UserController
import com.example.exercicio.repository.UserRepository

class CalendarActivity : AppCompatActivity() {

    var calendarController = CalendarController()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)
    }

    fun confirm(view: View) {
        var calendar = findViewById<CalendarView>(R.id.calendarView)
        val dateTime = calendar?.getDate().toString()
        this.calendarController.addCalendar(this, dateTime, this)
        val intent = Intent(this, ListScreen::class.java)
        startActivity(intent)
    }

}
