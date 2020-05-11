package com.example.proyecfor10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //btnCancelar to Login
        btnCancelar.setOnClickListener {
            val intent:Intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }
}
