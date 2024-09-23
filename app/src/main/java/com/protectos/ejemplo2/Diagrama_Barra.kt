package com.protectos.ejemplo2

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.echo.holographlibrary.Bar
import com.echo.holographlibrary.BarGraph
import com.protectos.ejemplo2.databinding.ActivityDiagramaBarraBinding

import kotlin.math.roundToInt

class Diagrama_Barra : AppCompatActivity() {

    private lateinit var vinculo: ActivityDiagramaBarraBinding
    //val  = findViewById<Button>(R.id.myButton)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vinculo = ActivityDiagramaBarraBinding.inflate(layoutInflater)
        setContentView(vinculo.root)

        val puntos = ArrayList<Bar>()

        // creacion de array para almacenar los datos de los puntos
       // binding.btnAgregar.setOnClickListener {
         //   graficarPuntos(puntos)
           // binding.etConcepto.setText("");
            //binding.etConcepto.invalidate();
           // binding.etCantidad.setText("");
          //  binding.etCantidad.invalidate();
        //}

        // declaracion de varibles para las id del activity
        //val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        //val etConcepto = findViewById<EditText>(R.id.etConcepto)
        //val etCantidad = findViewById<EditText>(R.id.etCantidad)
        vinculo.btnAgregar.setOnClickListener {

            graficarPuntos(puntos)
            //limpiar EditText
            vinculo.etConcepto.setText("")
            vinculo.etConcepto.invalidate()
            vinculo.etCantidad.setText("")
            vinculo.etCantidad.invalidate()
        }

    }
    fun graficarPuntos(puntos: ArrayList<Bar>){
        val barra = Bar()
        var color = generarColor()
        barra.color = Color.parseColor(color)
        barra.name = vinculo.etConcepto.text.toString()
        barra.value = vinculo.etCantidad.text.toString().toFloat()

        puntos.add(barra)

        val grafica = findViewById<View>(R.id.Grafico) as BarGraph
        grafica.bars = puntos
    }

    fun generarColor(): String {
        val letras = arrayOf("0", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")
        var color = "#"
        for (i in 0..5) {
            color += letras[(Math.random() * 15).roundToInt()]
        }
        return color
    }

}