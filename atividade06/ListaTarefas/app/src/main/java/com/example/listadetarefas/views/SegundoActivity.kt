package com.example.listadetarefas.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefas.R
import com.example.listadetarefas.adapter.AdapterListaTarefas
import com.example.listadetarefas.dao.ListaDaoTarefas

class SegundoActivity : AppCompatActivity() {
    val dao = ListaDaoTarefas();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_segundo)

        val recycler = findViewById<RecyclerView>(R.id.tarefas);

        val listTarefas = dao.obterLista();

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = AdapterListaTarefas(listTarefas)

    }
}