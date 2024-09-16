package com.example.listadetarefas.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listadetarefas.R
import com.example.listadetarefas.dao.ListaDaoTarefas
import com.example.listadetarefas.model.ListaT
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PrimeiroActivity : AppCompatActivity() {
    val dao = ListaDaoTarefas();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_primeiro)

        val edtNome = findViewById<EditText>(R.id.editNome);
        val edtDescri = findViewById<EditText>(R.id.editDiscriscao);
        val btn = findViewById<Button>(R.id.btn);
        val btnfloat = findViewById<FloatingActionButton>(R.id.btnfloat);

        btn.setOnClickListener {


            val nome = edtNome.text.toString();
            val descri = edtDescri.text.toString();

            val listaT = ListaT(nome,descri)

            dao.adionarTarefa(listaT);

            Toast.makeText(this,"item na lista adicionador",Toast.LENGTH_LONG).show();
            edtNome.text.clear();
            edtDescri.text.clear();




        }

        btnfloat.setOnClickListener {
            val intent = Intent(this,SegundoActivity::class.java);
            startActivity(intent)
        }
    }
}