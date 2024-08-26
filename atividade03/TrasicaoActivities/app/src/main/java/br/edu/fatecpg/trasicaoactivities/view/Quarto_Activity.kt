package br.edu.fatecpg.trasicaoactivities.view

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.trasicaoactivities.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Quarto_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quarto)

        val btn6 = findViewById<FloatingActionButton>(R.id.float_btn6)
        val btn8 = findViewById<FloatingActionButton>(R.id.float_btn8)

        val nomeA = findViewById<EditText>(R.id.nome)
        nomeA.text.toString();

        btn6.setOnClickListener {
            finish()
        }

        btn8.setOnClickListener {
            val intent = Intent(this,quinto_Activity::class.java)
            var nome = nomeA.text.toString();
            intent.putExtra("aluno",nome);

            startActivity(intent)

        }
    }
}


