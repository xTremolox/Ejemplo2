package com.protectos.ejemplo2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper()).postDelayed({
            // Iniciar la nueva actividad
            val intent = Intent(this, Pantalla_Principal::class.java)
            startActivity(intent)
            // Finalizar la actividad actual (opcional)
            finish()
        }, 3000)





        fun suma(){
            //Funcion suma
        }
        fun resta(){

        }
        fun multiplicacion(){

        }
    }
}