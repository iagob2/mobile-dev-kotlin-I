package br.edu.fatecpg.trasicaoactivities.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.trasicaoactivities.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Segunda_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_segunda)

        val btn2 = findViewById<FloatingActionButton>(R.id.float_btn2);
        val btn3 = findViewById<FloatingActionButton>(R.id.float_btn3);

        val autor = findViewById<EditText>(R.id.edit_autor)
        val titulo = findViewById<EditText>(R.id.edit_titulo)

        btn2.setOnClickListener{
            finish()
        }

        btn3.setOnClickListener{
            val intent = Intent(this,Terceiro_Activity::class.java)
            intent.putExtra("autor",autor.text.toString())
            intent.putExtra("titulo",titulo.text.toString())
            startActivity(intent)

        }
    }
    override  fun onStart() {
        super.onStart()
        Log.i("Entrou no OnStart",
            intent.getStringExtra("Dado")?:"Nada Encontrando ")

    }
}