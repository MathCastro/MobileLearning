package com.example.exercicio.view

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.exercicio.R

class CalculatorActivity : AppCompatActivity() {

    var firstOperand: TextView? = null
    var secondOperand: TextView? = null
    var error: TextView? = null
    var result: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "New Activity"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        firstOperand = findViewById(R.id.firstOperand)
        secondOperand = findViewById(R.id.secondOperand)
        error = findViewById(R.id.textError)
        result = findViewById(R.id.result)
    }

    fun sum(view: View) {
        if(firstOperand?.text.toString() != "" && secondOperand?.text.toString().toString() != "" && firstOperand?.text.toString().length < 10 && secondOperand?.text.toString().length < 10) {
            result?.setText((Integer.parseInt(firstOperand?.text.toString()).toLong() + Integer.parseInt(secondOperand?.text.toString()).toLong()).toString())
            error?.setText("")
        } else {
            error?.setText("Error: operation not allowed")
        }
    }

    fun sub(view: View) {
        if(firstOperand?.text.toString() != "" && secondOperand?.text.toString().toString() != "" && firstOperand?.text.toString().length < 10 && secondOperand?.text.toString().length < 10) {
            result?.setText((Integer.parseInt(firstOperand?.text.toString()).toLong() - Integer.parseInt(secondOperand?.text.toString()).toLong()).toString())
            error?.setText("")
        } else {
            error?.setText("Error: operation not allowed")
        }
    }

    fun mul(view: View) {
        if(firstOperand?.text.toString() != "" && secondOperand?.text.toString() != "" && firstOperand?.text.toString().length < 10 && secondOperand?.text.toString().length < 10){
            result?.setText((Integer.parseInt(firstOperand?.text.toString()).toLong() * Integer.parseInt(secondOperand?.text.toString()).toLong()).toString())
            error?.setText("")
        } else {
            error?.setText("Error: operation not allowed")
        }
    }

    fun div(view: View) {
        if(firstOperand?.text.toString() != "" && secondOperand?.text.toString().toString() != "" && secondOperand?.text.toString().toString() != "0"&& firstOperand?.text.toString().length < 10 && secondOperand?.text.toString().length < 10) {
            result?.setText((Integer.parseInt(firstOperand?.text.toString()).toLong() / Integer.parseInt(secondOperand?.text.toString()).toLong()).toString())
            error?.setText("")
        } else {
            error?.setText("Error: operation not allowed")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
