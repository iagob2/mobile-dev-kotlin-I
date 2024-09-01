package com.example.calculadoraimcapplication.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimcapplication.R
import com.example.calculadoraimcapplication.dao.UsuarioDao
import com.example.calculadoraimcapplication.model.Usuario
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RespotarActivity : AppCompatActivity() {
    private val dao = UsuarioDao()

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respotar)

        val float_btn = findViewById<FloatingActionButton>(R.id.btn_float)
        val txt_altura = findViewById<TextView>(R.id.txt_altura)
        val txt_peso = findViewById<TextView>(R.id.txt_peso)
        val txt_imc = findViewById<TextView>(R.id.txt_imc)
        val txt_resp = findViewById<TextView>(R.id.txt_resp)

        val usuario: Usuario = dao.exibirUsuario()

        val altura = usuario.altura
        val peso = usuario.peso
        val imc = peso / (altura * altura)

        // Atualiza os TextViews com os valores
        txt_altura.text = "Altura: ${altura}m"
        txt_peso.text = "Peso: ${peso}kg"
        txt_imc.text = "IMC: ${String.format("%.2f", imc)}"

        // Determina a resposta com base no IMC usando if
        val resposta: String = if (imc < 18.5) {
            " Abaixo do peso "
        } else if (imc in 18.5..24.9) {
            " Peso normal "
        } else if (imc in 25.0..29.9) {
            " Sobrepeso "
        } else {
            " Obesidade "
        }

        txt_resp.text = resposta

        float_btn.setOnClickListener {
            finish()
        }
    }
}
