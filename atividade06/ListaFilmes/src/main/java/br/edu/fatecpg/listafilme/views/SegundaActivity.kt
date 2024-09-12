package br.edu.fatecpg.listafilme.views

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.listafilme.R
import br.edu.fatecpg.listafilme.adapter.ListaFilmesAdapter
import br.edu.fatecpg.listafilme.dao.ListaDaoFilmes

class SegundaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val dao = ListaDaoFilmes()
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_segunda)

        Log.i("listFilmes",dao.obterFilmes().toString())



        val recycler = findViewById<RecyclerView>(R.id.listFimes)

        val listfimes = dao.obterFilmes()

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ListaFilmesAdapter(listfimes)




    }
}