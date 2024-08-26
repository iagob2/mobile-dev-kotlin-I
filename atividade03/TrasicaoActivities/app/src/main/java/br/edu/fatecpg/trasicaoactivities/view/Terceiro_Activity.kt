package br.edu.fatecpg.trasicaoactivities.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.trasicaoactivities.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Terceiro_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_terceiro)

        val btn4 = findViewById<FloatingActionButton>(R.id.float_btn4);

        btn4.setOnClickListener{
            finish()
        }

        val autor = intent.getStringExtra("autor")?: "Autor não especificado"
        val titulo = intent.getStringExtra("titulo") ?: "Título não especificado"


        val autorTextView = findViewById<TextView>(R.id.text_autor)
        val tituloTextView = findViewById<TextView>(R.id.text_titulo)

        autorTextView.text = "Autor: $autor"
        tituloTextView.text = "Título: $titulo"





    }
}