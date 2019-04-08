package com.example.exercicio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.exercicio.model.UserBO
import com.example.exercicio.repository.UserRepository
import com.example.exercicio.view.ListScreen

class MainActivity : AppCompatActivity() {

    var user: UserBO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val login = findViewById(R.id.loginButton) as Button
        val email = findViewById(R.id.email) as EditText
        val password = findViewById(R.id.password) as EditText

        login.setOnClickListener() {
            val dbHandler = UserRepository(this, null, null, 1)
            val user = UserBO(email.text.toString(), password.text.toString())
            this.user = dbHandler.findUser(user)
            val intent = Intent(this, ListScreen::class.java)
            if(this.user != null) {
                startActivity(intent)
            }
        }
    }
}
