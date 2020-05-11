package com.example.proyecfor10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.example.proyecfor10.Login

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        // Making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        //3 seconds splash time
        Handler().postDelayed({
            //start main_activity
           startActivity(Intent(this@MainActivity, Login::class.java))
            //Finish splash
            finish()
        },3000)
    }
}
