package com.example.proyecfor10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.proyecfor10.Model.Users
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    lateinit var usuario:EditText
    lateinit var password:EditText
    lateinit var type:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        usuario = findViewById(R.id.user)
        password = findViewById(R.id.password)


        //btnRegister to Register
        btnRegister.setOnClickListener {
            val intent:Intent = Intent(this, Register::class.java)
            startActivity(intent)
        }

        //btnHome to Home
        btnHome.setOnClickListener {
            val name = usuario.text.toString().trim()
            val pass = password.text.toString().trim()

            if (name.isEmpty()){
                usuario.error = "Coloca tu email"
                usuario.requestFocus()
                return@setOnClickListener
            }else if(pass.isEmpty()){
                password.error = "Coloca una contraseña"
                password.requestFocus()
                return@setOnClickListener
            }

            val intent:Intent = Intent(this, Home::class.java)

            val query:Query =FirebaseDatabase.getInstance().getReference("usuarios")
                .orderByChild("email")
                .equalTo(usuario.text.toString())

            query.addValueEventListener(object: ValueEventListener{
                override fun onCancelled(p0: DatabaseError) {
                    TODO("Not yet implemented")
                }

                override fun onDataChange(p0: DataSnapshot) {
                    if(p0!!.exists()){
                        val queryP:Query =FirebaseDatabase.getInstance().getReference("usuarios")
                            .orderByChild("password")
                            .equalTo(password.text.toString())
                        queryP.addValueEventListener(object: ValueEventListener{
                            override fun onCancelled(p0: DatabaseError) {
                                TODO("Not yet implemented")
                            }
                            override fun onDataChange(p0: DataSnapshot) {
                                if(p0!!.exists()){
                                    startActivity(intent)
                                }else{
                                    Toast.makeText(applicationContext,"Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                                }
                            }

                        })
                    }else{
                        Toast.makeText(applicationContext,"Usuario incorrecto", Toast.LENGTH_SHORT).show()
                    }
                }

            })

        }
    }


}
