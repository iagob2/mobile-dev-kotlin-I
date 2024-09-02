package com.example.consultarcapapplication.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.consultarcapapplication.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class segundaTelaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_tela)

        val txtRua = findViewById<TextView>(R.id.txt_rua)
        val txtBairro = findViewById<TextView>(R.id.txt_bairro)
        val txtCidade = findViewById<TextView>(R.id.txt_cidade)
        val txtEstado = findViewById<TextView>(R.id.txt_estado)

        // Obtém os dados passados pela Intent e exibe na UI.
        val logradouro = intent.getStringExtra("logradouro") ?: "Não disponível"
        val bairro = intent.getStringExtra("bairro") ?: "Não disponível"
        val cidade = intent.getStringExtra("cidade") ?: "Não disponível"
        val estado = intent.getStringExtra("estado") ?: "Não disponível"

        txtRua.text = logradouro
        txtBairro.text = bairro
        txtCidade.text = cidade
        txtEstado.text = estado

        val btnFloat = findViewById<FloatingActionButton>(R.id.btn_float)
        btnFloat.setOnClickListener {
            finish()
        }
    }
}
