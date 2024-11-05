package br.edu.fatecpg.produtos.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.fatecpg.produtos.adapter.ListaProdutosAdapter
import br.edu.fatecpg.produtos.dao.carregarProdutos
import br.edu.fatecpg.produtos.databinding.ActivityMain2Binding
import br.edu.fatecpg.produtos.model.ListaP

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var adapter: ListaProdutosAdapter
    private val listaProdutos = mutableListOf<ListaP>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurando o RecyclerView
        adapter = ListaProdutosAdapter(listaProdutos)
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity2)
            adapter = this@MainActivity2.adapter
        }

        // Chamando a função carregarProdutos do ProdutoRepository
        carregarProdutos(
            callback = { produtos ->
                listaProdutos.clear()
                listaProdutos.addAll(produtos) // Adiciona os produtos carregados à lista
                adapter.notifyDataSetChanged() // Atualiza o adapter
            },
            onError = { mensagemErro ->
                Toast.makeText(this, "Erro ao carregar produtos: $mensagemErro", Toast.LENGTH_SHORT).show()
            }
        )
    }
}
