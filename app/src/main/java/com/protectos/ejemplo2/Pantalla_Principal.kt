package com.protectos.ejemplo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Pantalla_Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_principal)
        //declaracion de boton para pasar al diagrama
        val btnBarra: Button = findViewById(R.id.btnMatematica)

        btnBarra.setOnClickListener{
            val accion = Intent(this,Diagrama_Barra::class.java)
            startActivity(accion)
        }
    }
}