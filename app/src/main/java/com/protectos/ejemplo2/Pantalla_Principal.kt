package com.protectos.ejemplo2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Pantalla_Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_principal)
        //declaracion de boton para pasar al diagrama
        val btnBarra: Button = findViewById(R.id.btnMatematica)
        val btnSuma: Button = findViewById(R.id.btnComunicacion)


        btnBarra.setOnClickListener{
            val accion = Intent(this,Diagrama_Barra::class.java)
            startActivity(accion)
            overridePendingTransition(R.xml.fade_in, R.xml.fade_out)
        }
        btnSuma.setOnClickListener{
            val accion = Intent(this,ActividadSuma::class.java)
            startActivity(accion)
            overridePendingTransition(R.xml.fade_in, R.xml.fade_out)
        }
    }
}