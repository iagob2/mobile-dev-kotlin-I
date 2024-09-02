package com.example.consultarcapapplication.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.consultarcapapplication.R
import com.example.consultarcapapplication.dao.ConsumirApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsuarioActivity : AppCompatActivity() {
    private val consumir = ConsumirApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        val editCep = findViewById<EditText>(R.id.edit_cep)
        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            val cep = editCep.text.toString()

            // Executa a consulta do CEP em segundo plano.
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val endereco = consumir.lerEnderecoPorCep(cep)

                    // Transfere o endereço para a segunda tela usando Intent.
                    val intent = Intent(this@UsuarioActivity, segundaTelaActivity::class.java).apply {
                        putExtra("logradouro", endereco.logradouro)
                        putExtra("bairro", endereco.bairro)
                        putExtra("cidade", endereco.cidade)
                        putExtra("estado", endereco.estado)
                    }

                    withContext(Dispatchers.Main) {
                        startActivity(intent)
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}
