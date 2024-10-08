package com.protectos.ejemplo2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.protectos.ejemplo2.databinding.ActivitySumaBinding

import com.protectos.ejemplo2.databinding.NivelesSumaBinding

class ActividadSuma : AppCompatActivity() {
    private lateinit var vinculo1: ActivitySumaBinding
    private lateinit var vinculo2: NivelesSumaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        vinculo1 = ActivitySumaBinding.inflate(layoutInflater)
        vinculo2 = NivelesSumaBinding.inflate(layoutInflater)
        setContentView(vinculo1.root)


    }
    fun nivel1(view: View){
        val accion = Intent(this,Actividad_JuegoSuma::class.java)
        startActivity(accion)
    }
    fun Bloquedo(view: View){
        val texto = view.contentDescription.toString()
        Toast.makeText(this, "¡¡Nivel Bloquedo!!", Toast.LENGTH_SHORT).show()
    }
}