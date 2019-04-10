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
    var result: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        firstOperand = findViewById(R.id.firstOperand)
        secondOperand = findViewById(R.id.secondOperand)
        result = findViewById(R.id.result)
    }

    fun sum(view: View) {
        result?.setText((Integer.parseInt(firstOperand?.text.toString()) + Integer.parseInt(secondOperand?.text.toString())).toString())
    }

    fun sub(view: View) {
        result?.setText((Integer.parseInt(firstOperand?.text.toString()) - Integer.parseInt(secondOperand?.text.toString())).toString())
    }

    fun mul(view: View) {
        result?.setText((Integer.parseInt(firstOperand?.text.toString()) * Integer.parseInt(secondOperand?.text.toString())).toString())
    }

    fun div(view: View) {
        result?.setText((Integer.parseInt(firstOperand?.text.toString()) / Integer.parseInt(secondOperand?.text.toString())).toString())
    }
}
