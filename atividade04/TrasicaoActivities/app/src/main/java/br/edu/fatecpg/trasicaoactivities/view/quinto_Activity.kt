package br.edu.fatecpg.trasicaoactivities.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.trasicaoactivities.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class quinto_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quinto)

        var btn9 = findViewById<FloatingActionButton>(R.id.float_btn9)

        btn9.setOnClickListener{
            finish()
        }
        var rand = Random(10000)


        val aluno = intent.getStringExtra("aluno")?: "aluno não especificado"


        val alunoTextView = findViewById<TextView>(R.id.text_aluno)
        val randTextView = findViewById<TextView>(R.id.text_rand)

        alunoTextView.text = "Aluno: $aluno"
        randTextView.text = "Matricula: $rand"
    }
}