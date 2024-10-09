package com.example.app01.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app01.databinding.ActivitySegundaBinding
import com.example.app01.adapter.ListaUsuarioAdapter
import com.example.app01.viewmodel.LoginViewModel

class SegundaActivity : AppCompatActivity() {
    private val viewModel = LoginViewModel()
    private lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtém a lista de usuários do ViewModel
        val listaUsuario = viewModel.mostrarUsuario()

        // Configura o RecyclerView
        val recycler = binding.recyclerView
        recycler.layoutManager = LinearLayoutManager(this)

        // Verifica se a lista não está vazia antes de configurar o adaptador
        if (listaUsuario.isNotEmpty()) {
            recycler.adapter = ListaUsuarioAdapter(listaUsuario)
        } else {
            // Você pode adicionar uma mensagem ou uma visualização vazia aqui
            // Exemplo: binding.textViewEmpty.visibility = View.VISIBLE
        }
    }
}
