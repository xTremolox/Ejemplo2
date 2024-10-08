package com.protectos.ejemplo2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.protectos.ejemplo2.databinding.ActivityJuegoSumaBinding
import kotlin.random.Random

class Actividad_JuegoSuma : AppCompatActivity() {
    private lateinit var vinculo: ActivityJuegoSumaBinding
    private var correctAnswers = 0
    private var suma=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        vinculo= ActivityJuegoSumaBinding.inflate(layoutInflater)
        setContentView(vinculo.root)
        generateQuestion()

        vinculo.rpta1.setOnClickListener(){
            checkAnswer1()
        }
        vinculo.rpta2.setOnClickListener(){
            checkAnswer2()
        }
        vinculo.rpta3.setOnClickListener(){
            checkAnswer3()
        }

    }
    private fun generateQuestion() {
        val num1 = Random.nextInt(5,10)
        val num2 = Random.nextInt(5, 10)
        vinculo.btnNum1.text = "$num1"
        vinculo.btnNum2.text = "$num2"
        suma=num1+num2

        val opciones = listOf(suma, suma + 1, suma + 2).shuffled()

        vinculo.rpta1.text = opciones[0].toString()
        vinculo.rpta2.text = opciones[1].toString()
        vinculo.rpta3.text = opciones[2].toString()
    }

    private fun checkAnswer1() {
        var rpta= vinculo.rpta1.text.toString().toIntOrNull() ?: 0
        validar(rpta)

    }
    private fun checkAnswer2() {
        var rpta= vinculo.rpta2.text.toString().toIntOrNull() ?: 0
        validar(rpta)

    }
    private fun checkAnswer3() {
        var rpta= vinculo.rpta3.text.toString().toIntOrNull() ?: 0
        validar(rpta)

    }

    private fun validar(rpta: Int) {
        if (rpta==suma) {
            correctAnswers++

            Toast.makeText(this, "CORRECTO", Toast.LENGTH_LONG).show()

            generateQuestion()
            if (correctAnswers == 10) {
                Toast.makeText(this, "¡Felicidades! Has acertado 10 veces.", Toast.LENGTH_LONG).show()
                correctAnswers = 0
            }
        } else {
            Toast.makeText(this, "INCORRECTO", Toast.LENGTH_LONG).show()
            //limpiar EditText
            vinculo.rpta1.setText("")
            vinculo.rpta1.invalidate()
            vinculo.rpta2.setText("")
            vinculo.rpta2.invalidate()
            vinculo.rpta3.setText("")
            vinculo.rpta3.invalidate()
            generateQuestion()
        }
    }
}