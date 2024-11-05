package br.edu.fatecpg.produtos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.produtos.R
import br.edu.fatecpg.produtos.model.ListaP

class ListaProdutosAdapter(private val listaProdutos: MutableList<ListaP>) :
    RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    class ViewHolder(ProdutoView: View) : RecyclerView.ViewHolder(ProdutoView) {
        val txvNome: TextView = ProdutoView.findViewById(R.id.txt_nome)
        val txvCategori: TextView = ProdutoView.findViewById(R.id.txt_categori)
        val txvPreco: TextView = ProdutoView.findViewById(R.id.txt_preco)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.produto, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = listaProdutos[position]
        holder.txvNome.text = produto.nome
        holder.txvCategori.text = produto.categori
        holder.txvPreco.text = "R$ ${produto.preco}"
    }

    override fun getItemCount(): Int {
        return listaProdutos.size
    }
}
