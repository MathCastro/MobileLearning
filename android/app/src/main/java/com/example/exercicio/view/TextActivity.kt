package com.example.exercicio.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.exercicio.R
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.EditText
import com.example.exercicio.controller.UserController
import com.example.exercicio.model.TextBO
import com.example.exercicio.repository.UserRepository
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView


class TextActivity : AppCompatActivity() {

    var userController = UserController()
    var texts = mutableListOf<String>()
    var values = mutableListOf<TextBO>()
    var listView1: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)

        val dbHandler = UserRepository(this, null, null, 1)

        values = dbHandler.findText()!!

        listView1 = findViewById(R.id.text_list) as ListView

        if(values != null) {

            for(elem in values) {
                var texto = elem.text!!
                if(texto.length > 20) {
                    texts.add(texto.take(50) + "...")
                } else {
                    texts.add(elem.text!!)
                }
            }

            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1, texts
            )
            listView1!!.setAdapter(adapter)
        }

        setupListViewListener()
    }

    fun addText(view: View) {
        val dbHandler = UserRepository(this, null, null, 1)
        val taskEditText = EditText(this)
        var user = dbHandler.findUserByEmail(userController.getLoggedUser(this)!!)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Add a new text")
            .setView(taskEditText)
            .setPositiveButton("Add", DialogInterface.OnClickListener { dialog, which ->
                val text = taskEditText.text.toString()
                dbHandler.addText(TextBO(text, user?.id!!))
                if(text.length > 20) {
                    texts.add(text.take(50) + "...")
                } else {
                    texts.add(text)
                }
                values = dbHandler.findText()!!
                listView1!!.deferNotifyDataSetChanged()
            })
            .setNegativeButton("Cancel", null)
            .create()
        dialog.show()
    }

    fun setupListViewListener() {
        var result: ListView = findViewById(R.id.text_list)

        result.setOnItemClickListener { parent, view, position, id ->
            val dialog = AlertDialog.Builder(this)
                .setMessage(values.get(position).text)
                .create()
            dialog.show()

        }
    }
}
