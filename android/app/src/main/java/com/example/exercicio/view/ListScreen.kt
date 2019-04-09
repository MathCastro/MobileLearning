package com.example.exercicio.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.exercicio.R
import com.example.exercicio.model.UserBO

class ListScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_screen)
    }

    fun calendar(view: View) {
        val intent = Intent(this, CalendarActivity::class.java)
        startActivity(intent)
    }

    fun calculator(view: View) {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }

    fun idiom(view: View) {
        val intent = Intent(this, IdiomActivity::class.java)
        startActivity(intent)
    }

    fun tabBar(view: View) {
        val intent = Intent(this, TabBarActivity::class.java)
        startActivity(intent)
    }

    fun text(view: View) {
        val intent = Intent(this, TextActivity::class.java)
        startActivity(intent)
    }

}
