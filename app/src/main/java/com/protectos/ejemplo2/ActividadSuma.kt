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
        overridePendingTransition(R.xml.fade_in, R.xml.fade_out)
    }
    fun nivel2(view: View){
        val accion = Intent(this,Actividad_Juego_Suma2_1::class.java)
        startActivity(accion)
        overridePendingTransition(R.xml.fade_in, R.xml.fade_out)
    }
    fun nivel3(view: View){
        val accion = Intent(this,Actividad_Juego_Suma3_1::class.java)
        startActivity(accion)
        overridePendingTransition(R.xml.fade_in, R.xml.fade_out)
    }
    fun nivel4(view: View){
        val accion = Intent(this,Actividad_Juego_Suma4_1::class.java)
        startActivity(accion)
        overridePendingTransition(R.xml.fade_in, R.xml.fade_out)
    }
    fun nivel5(view: View){
        val accion = Intent(this,Actividad_Juego_Suma5_1::class.java)
        startActivity(accion)
        overridePendingTransition(R.xml.fade_in, R.xml.fade_out)
    }

}