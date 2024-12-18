package com.protectos.ejemplo2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.protectos.ejemplo2.databinding.ActivityJuegoSuma37Binding
import com.protectos.ejemplo2.databinding.ActivityJuegoSuma54Binding
import com.protectos.ejemplo2.databinding.ScoresumaBinding
import kotlin.random.Random

class Actividad_Juego_Suma5_4 : AppCompatActivity() {
    private lateinit var vinculo: ActivityJuegoSuma54Binding
    private lateinit var vinculo2: ScoresumaBinding
    private var correctAnswers = 0
    private var incorrectAnswers = 0
    private var suma=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        vinculo= ActivityJuegoSuma54Binding.inflate(layoutInflater)


        setContentView(vinculo.root)

        generateQuestion()

        vinculo.rpta1.setOnClickListener(){
            validar(vinculo.rpta1.text.toString().toIntOrNull() ?: 0)
        }
        vinculo.rpta2.setOnClickListener(){
            validar(vinculo.rpta2.text.toString().toIntOrNull() ?: 0)
        }
        vinculo.rpta3.setOnClickListener(){
            validar(vinculo.rpta3.text.toString().toIntOrNull() ?: 0)
        }

    }
    private fun generateQuestion() {
        val num1 = Random.nextInt(200000,350000)
        val num2 = Random.nextInt(200000, 350000)
        vinculo.btnNum1.text = "$num1"
        vinculo.btnNum2.text = "$num2"
        suma=num1+num2

        val opciones = listOf(suma, suma + 300, suma - 200).shuffled()

        vinculo.rpta1.text = opciones[0].toString()
        vinculo.rpta2.text = opciones[1].toString()
        vinculo.rpta3.text = opciones[2].toString()
    }
    //

    private fun validar(rpta: Int) {
        if (rpta==suma) {
            correctAnswers++

            Toast.makeText(this, "CORRECTO", Toast.LENGTH_LONG).show()
            vinculo.score.text = "$correctAnswers/16"
            //vinculo.score.text = correctAnswers.toString()
            Glide.with(this).asGif().load(R.drawable.bien).into(vinculo.bien)
            Handler(Looper.getMainLooper()).postDelayed({
                vinculo.bien.visibility = View.VISIBLE
                // Ocultar después de un tiempo
                Handler(Looper.getMainLooper()).postDelayed({
                    vinculo.bien.visibility = View.INVISIBLE
                }, 2500)
            }, 1)
            Handler(Looper.getMainLooper()).postDelayed({
                limpiar()
                Handler(Looper.getMainLooper()).postDelayed({
                    generateQuestion()
                }, 500)
            }, 2000)

            if (correctAnswers == 16) {
                Toast.makeText(this, "¡Felicidades! Has acertado 16 veces.", Toast.LENGTH_LONG).show()
                Handler(Looper.getMainLooper()).postDelayed({
                    generateQuestion()
                }, 1000)

                finalJuego()

            }

        } else {
            incorrectAnswers++
            Toast.makeText(this, "INCORRECTO", Toast.LENGTH_LONG).show()
            //limpiar EditText
            Glide.with(this).asGif().load(R.drawable.mal).into(vinculo.mal)
            Handler(Looper.getMainLooper()).postDelayed({
                vinculo.mal.visibility = View.VISIBLE
                // Ocultar después de un tiempo
                Handler(Looper.getMainLooper()).postDelayed({
                    vinculo.mal.visibility = View.INVISIBLE
                }, 2500)
            }, 1)
            Handler(Looper.getMainLooper()).postDelayed({
                limpiar()
                Handler(Looper.getMainLooper()).postDelayed({
                    generateQuestion()
                }, 500)
            }, 2000)
            if (incorrectAnswers >= 5) {
                Toast.makeText(this, "Has alcanzado el límite de errores.", Toast.LENGTH_LONG).show()
                finalJuego()
                Handler(Looper.getMainLooper()).postDelayed({
                    generateQuestion()
                }, 300)
            }
        }
    }

    private fun finalJuego() {
        //val scoresumax = findViewById<View>(R.id.scoresumax)
        vinculo2= ScoresumaBinding.inflate(layoutInflater)
        setContentView(vinculo2.root)

        val totalAttempts = correctAnswers + incorrectAnswers
        val scorePercentage = if (totalAttempts > 0) (correctAnswers * 100) / totalAttempts else 0

        //val scoresuma = vinculo.scoresumax
        //scoresumax.visibility = View.VISIBLE

        // Actualizar los TextViews con los datos
        vinculo2.textCorrectas.text = "Correctas: $correctAnswers"
        vinculo2.textIncorrectas.text = "Incorrectas: $incorrectAnswers"
        vinculo2.textPuntaje.text = "Puntaje: $scorePercentage%"

        // Configurar el botón para reiniciar el juego

        vinculo2.btnSiguiente.isEnabled = false

        // Habilitar `btnSiguiente` si el puntaje es mayor al 50%
        if (scorePercentage > 50) {
            vinculo2.btnSiguiente.isEnabled = true
        }
        vinculo2.btnReiniciar.setOnClickListener {
            // Ocultar el layout `niveles_suma`
            setContentView(vinculo.root)
            //scoresumax.visibility = View.GONE

            // Reiniciar variables
            correctAnswers = 0
            incorrectAnswers = 0
            vinculo.score.text = correctAnswers.toString()

            // Iniciar una nueva pregunta
            generateQuestion()
        }
        vinculo2.btnMenu.setOnClickListener(){
            correctAnswers = 0
            incorrectAnswers = 0
            vinculo.score.text = correctAnswers.toString()
            val accion = Intent(this,ActividadSuma::class.java)
            startActivity(accion)
            overridePendingTransition(R.xml.fade_in, R.xml.fade_out)
        }
        vinculo2.btnSiguiente.setOnClickListener{
            correctAnswers = 0
            incorrectAnswers = 0
            vinculo.score.text = correctAnswers.toString()

            val accion = Intent(this,Actividad_Juego_Suma5_5::class.java)
            startActivity(accion)
            overridePendingTransition(R.xml.fade_in, R.xml.fade_out)
            Handler(Looper.getMainLooper()).postDelayed({
                generateQuestion()
            }, 300)
        }

    }

    fun limpiar(){
        vinculo.btnNum1.setText("")
        vinculo.rpta1.invalidate()
        vinculo.btnNum2.setText("")
        vinculo.rpta1.invalidate()
        vinculo.rpta1.setText("")
        vinculo.rpta1.invalidate()
        vinculo.rpta2.setText("")
        vinculo.rpta2.invalidate()
        vinculo.rpta3.setText("")
        vinculo.rpta3.invalidate()
    }
}