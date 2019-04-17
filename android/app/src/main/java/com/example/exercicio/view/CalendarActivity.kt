package com.example.exercicio.view

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import com.example.exercicio.R
import com.example.exercicio.controller.CalendarController
import com.example.exercicio.controller.UserController
import com.example.exercicio.repository.UserRepository
import java.text.SimpleDateFormat
import java.util.*

class CalendarActivity : AppCompatActivity() {

    var calendarController = CalendarController()
    var curDate: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        var calendar = findViewById<CalendarView>(R.id.calendarView)
        calendar.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
            val convertMonth = month + 1
            curDate = "$dayOfMonth/$convertMonth/$year"
            val date = curDate
            this.calendarController.addCalendar(this, date!!, this)
        })
    }

    fun confirm(view: View) {
        if(curDate == null) {
            var calendar = findViewById<CalendarView>(R.id.calendarView)
            val dateTime = calendar?.getDate().toString()
            this.calendarController.addCalendar(this, getDate(dateTime.toLong(), "dd/MM/yyyy"), this)
        }
        val intent = Intent(this, ListScreen::class.java)
        startActivity(intent)
    }

    fun getDate(milliSeconds: Long, dateFormat: String): String {
        // Create a DateFormatter object for displaying date in specified format.
        val formatter = SimpleDateFormat(dateFormat)

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        val calendar = Calendar.getInstance()
        calendar.setTimeInMillis(milliSeconds)
        return formatter.format(calendar.getTime())
    }

}
