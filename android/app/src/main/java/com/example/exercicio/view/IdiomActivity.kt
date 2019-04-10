package com.example.exercicio.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicio.R
import android.os.Build
import android.content.Context
import java.util.*

class IdiomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idiom)
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

}
