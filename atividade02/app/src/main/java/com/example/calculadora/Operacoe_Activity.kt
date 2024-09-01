package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Operacoe_Activity : AppCompatActivity() {

    private lateinit var resultado: TextView
    private var Resul: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operacoe)

        // Aplicando padding conforme as margens do sistema (barra de status, etc.)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultado = findViewById<EditText>(R.id.resultado)


        val editNum1 = findViewById<EditText>(R.id.num1)
        val editNum2 = findViewById<EditText>(R.id.num2)

        val btnAd = findViewById<Button>(R.id.btn_adicao)
        val btnSub = findViewById<Button>(R.id.btn_subtracao)
        val btnMult = findViewById<Button>(R.id.btn_multiplicacao)
        val btnDiv = findViewById<Button>(R.id.btn_divisao)

        btnAd.setOnClickListener {
            val num1 = editNum1.text.toString().toDoubleOrNull()
            val num2 = editNum2.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                Resul = num1 + num2
                resultado.visibility = View.VISIBLE
                resultado.text = "Resultado: $Resul"
            } else {
                Toast.makeText(this, "Por favor, insira números válidos", Toast.LENGTH_SHORT).show()
            }
        }

        btnSub.setOnClickListener {
            val num1 = editNum1.text.toString().toDoubleOrNull()
            val num2 = editNum2.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                Resul = num1 - num2
                resultado.visibility = View.VISIBLE
                resultado.text = "Resultado: $Resul"            } else {
                Toast.makeText(this, "Por favor, insira números válidos", Toast.LENGTH_SHORT).show()
            }
        }

        btnMult.setOnClickListener {
            val num1 = editNum1.text.toString().toDoubleOrNull()
            val num2 = editNum2.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                Resul = num1 * num2
                resultado.visibility = View.VISIBLE
                resultado.text = "Resultado: $Resul"
            } else {
                Toast.makeText(this, "Por favor, insira números válidos", Toast.LENGTH_SHORT).show()
            }
        }

        btnDiv.setOnClickListener {
            val num1 = editNum1.text.toString().toDoubleOrNull()
            val num2 = editNum2.text.toString().toDoubleOrNull()

            if (num1 != null && num2 != null) {
                if (num2 != 0.0) {
                    Resul = num1 / num2
                    resultado.visibility = View.VISIBLE
                    resultado.text = "Resultado: $Resul"                } else {
                    Toast.makeText(this, "Divisão por zero não é permitida", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, insira números válidos", Toast.LENGTH_SHORT).show()
            }
        }

        val btnVolta = findViewById<Button>(R.id.volta)
        btnVolta.setOnClickListener {
            // Fecha o Operacoe_Activity e volta para a MainActivity
            finish()
        }
    }
}
