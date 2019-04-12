package com.example.exercicio.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.exercicio.R
import com.example.exercicio.model.UserBO

class ListScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_screen)

        var options: Array<String> = resources.getStringArray(R.array.options_array)

        val prodAdapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, options)

        val list: ListView = findViewById(R.id.initial_list)

        list.adapter = prodAdapter

        list.setOnItemClickListener { parent, view, position, id ->
            if(position == 0)
                calendar()
            else if(position == 1)
                calculator()
            else if(position == 2)
                idiom()
            else if(position == 3)
                tabBar()
            else
                text()
        }
    }

    fun calendar(view: View? = null) {
        val intent = Intent(this, CalendarActivity::class.java)
        startActivity(intent)
    }

    fun calculator(view: View? = null) {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }

    fun idiom(view: View? = null) {
        val intent = Intent(this, IdiomActivity::class.java)
        startActivity(intent)
    }

    fun tabBar(view: View? = null) {
        val intent = Intent(this, TabBarActivity::class.java)
        startActivity(intent)
    }

    fun text(view: View? = null) {
        val intent = Intent(this, TextActivity::class.java)
        startActivity(intent)
    }

}
