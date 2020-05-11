package com.example.proyecfor10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //btnRegister to Register
        btnRegister.setOnClickListener {
            val intent:Intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        //btnHome to Home
        btnHome.setOnClickListener {
            val intent:Intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}
