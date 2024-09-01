package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OHM_Activity : AppCompatActivity() {

    private var btnOp: Int = 0
    private lateinit var resultado: TextView
    private lateinit var numero1: EditText
    private lateinit var numero2: EditText
    private  var result: String = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ohm)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inicializando as variáveis
        resultado = findViewById(R.id.resultado)
        numero1 = findViewById(R.id.num1)
        numero2 = findViewById(R.id.num2)

        val btnCalc = findViewById<Button>(R.id.btn_calcular)

        val btnTensao = findViewById<Button>(R.id.btn_tensao)
        val btnResist = findViewById<Button>(R.id.btn_resist)
        val btnCorente = findViewById<Button>(R.id.btn_corrente)

        btnTensao.setOnClickListener {
            btnOp = 1
            updateHint("Digite a Resistência:","Digite a Corrente:")
            result= "Tensão:"
        }

        btnResist.setOnClickListener {
            btnOp = 2
            updateHint("Digite a Tensão:","Digite a Corrente:")
            result= "Resistência:"
        }

        btnCorente.setOnClickListener {
            btnOp = 3
            updateHint("Digite a Tensão:","Digite a Resistência:")
            result = "Corrente:"
        }

        btnCalc.setOnClickListener {
            val num1 = numero1.text.toString().toDoubleOrNull()
            val num2 = numero2.text.toString().toDoubleOrNull()

            if (num1 == null || num2 == null) {
                Toast.makeText(this, "Por favor, insira números válidos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val resultantOpera: String = when (btnOp) {
                1 -> (num1 * num2).toString() // Calcula Tensão
                2 -> (num1 / num2).toString() // Calcula Resistência
                3 -> (num1 / num2).toString() // Calcula Corrente
                else -> "Opção inválida para Lei de Ohm"
            }

            resultado.visibility = View.VISIBLE
            resultado.text = "$result $resultantOpera"
        }

        val btnVolta = findViewById<Button>(R.id.volta)
        btnVolta.setOnClickListener {
            finish() // Fecha a OHM_Activity e volta para a Activity anterior
        }
    }

    // Função para atualizar o hint dos EditText
    private fun updateHint(hint1: String , hint2: String) {
        numero1.hint = hint1
        numero2.hint = hint2
    }
}
