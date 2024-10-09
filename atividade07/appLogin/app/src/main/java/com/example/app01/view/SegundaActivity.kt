package com.example.app01.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app01.databinding.ActivitySegundaBinding
import com.example.app01.adapter.ListaUsuarioAdapter
import com.example.app01.viewmodel.LoginViewModel

/**
 * SegundaActivity é responsável por exibir a lista de usuários cadastrados
 * em um RecyclerView e possui um botão para voltar à tela anterior.
 */
class SegundaActivity : AppCompatActivity() {

    // Instância do ViewModel para acessar dados dos usuários
    private val viewModel = LoginViewModel()

    // Binding para conectar os elementos da interface com o código
    private lateinit var binding: ActivitySegundaBinding

    /**
     * Função chamada ao criar a Activity.
     * Configura a interface e o RecyclerView.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout da Activity utilizando ViewBinding
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtém a lista de usuários a partir do ViewModel
        val listaUsuario = viewModel.mostrarUsuario()

        // Configura o RecyclerView com o layoutManager
        val recycler = binding.recyclerView
        recycler.layoutManager = LinearLayoutManager(this) // Layout vertical padrão

        // Verifica se a lista de usuários não está vazia
        if (listaUsuario.isNotEmpty()) {
            // Configura o adaptador do RecyclerView com a lista de usuários
            recycler.adapter = ListaUsuarioAdapter(listaUsuario)
        } else {
            // Exemplo de como exibir uma mensagem caso a lista esteja vazia
            // Isso pode ser feito exibindo uma TextView indicando que não há usuários
            // Exemplo: binding.textViewEmpty.visibility = View.VISIBLE
        }

        // Configura o botão "Voltar" para finalizar a Activity e voltar à tela anterior
        binding.btnVolta.setOnClickListener {
            finish() // Encerra a Activity e retorna para a anterior
        }
    }
}
