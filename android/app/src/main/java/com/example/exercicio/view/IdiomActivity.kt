package com.example.exercicio.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicio.R
import android.os.Build
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import java.util.*
import android.widget.AdapterView.OnItemSelectedListener
import java.security.AccessController.getContext


class IdiomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idiom)

        val spinner: Spinner = findViewById(R.id.spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.idiom_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                System.out.print(spinner.selectedItemPosition)
                if(spinner.selectedItemPosition == 1) {
                    updateResources(applicationContext, "en")
                    val intent = Intent(applicationContext, ListScreen::class.java)
                    startActivity(intent)
                } else if(spinner.selectedItemPosition == 2) {
                    updateResources(applicationContext, "pt")
                    val intent = Intent(applicationContext, ListScreen::class.java)
                    startActivity(intent)
                }

            }
        }
    }

    fun forceLocale(context: Context, localeCode: String) {
        val localeCodeLowerCase = localeCode.toLowerCase()

        val resources = context.getApplicationContext().getResources()
        val overrideConfiguration = resources.getConfiguration()
        val overrideLocale = Locale(localeCodeLowerCase)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            overrideConfiguration.setLocale(overrideLocale)
        } else {
            overrideConfiguration.locale = overrideLocale
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.getApplicationContext().createConfigurationContext(overrideConfiguration)
        } else {
            resources.updateConfiguration(overrideConfiguration, null)
        }

    }
    fun updateResources(context: Context, language: String): Context {

        var contextFun = context

        var locale = Locale(language)
        Locale.setDefault(locale)

        var resources = context.resources
        var configuration = Configuration(resources.configuration)

        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale)
            contextFun = context.createConfigurationContext(configuration)
        } else {
            configuration.locale = locale
            resources.updateConfiguration(configuration, resources.getDisplayMetrics())
        }
        return contextFun
    }

}

