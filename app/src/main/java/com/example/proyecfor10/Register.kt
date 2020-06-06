package com.example.proyecfor10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import com.example.proyecfor10.Model.Users
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    lateinit var edtName:EditText
    lateinit var edtEmail:EditText
    lateinit var edtPhone:EditText
    lateinit var edtPassword:EditText
    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        ref = FirebaseDatabase.getInstance().getReference("usuarios")

        edtName = findViewById(R.id.name)
        edtEmail = findViewById(R.id.email)
        edtPhone = findViewById(R.id.phone)
        edtPassword = findViewById(R.id.password)


        //Guardar
        btnGuardar.setOnClickListener {
            saveUser()
        }


        //btnCancelar to Login
        btnCancelar.setOnClickListener {
            val intent:Intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun saveUser(){
        val name = edtName.text.toString().trim()
        val email = edtEmail.text.toString().trim()
        val phone = edtPhone.text.toString().trim()
        val password = edtPassword.text.toString().trim()

        if (name.isEmpty()){
            edtName.error = "Ingresa un nombre"
            return
        }else if (email.isEmpty()) {
            edtEmail.error = "Ingresa un correo electronico"
            return
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            edtEmail.error = "Ingresa una cuenta de correo valida"
            return
        }else if (password.isEmpty()){
            edtPassword.error = "Ingresa una contraseña"
            return
        }

        val id_User = ref.push().key
        val type_user:String = "2"
        val users = Users(id_User.toString(),name,email,phone,password,type_user)

        ref.child(id_User.toString()).setValue(users).addOnCompleteListener{
            val intent:Intent = Intent(this, Login::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,"Gracias por registrarse", Toast.LENGTH_SHORT).show()
        }
    }
}
