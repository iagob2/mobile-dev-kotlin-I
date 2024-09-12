// Pacote onde a classe está localizada
package br.edu.fatecpg.listafilme.adapter

// Importações necessárias para a implementação
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.listafilme.R
import br.edu.fatecpg.listafilme.model.ListaF

// Definição da classe Adapter para a RecyclerView
class ListaFilmesAdapter(private val listafilmes: List<ListaF>) :
    RecyclerView.Adapter<ListaFilmesAdapter.ViewHolder>() {

    // Classe ViewHolder que mantém referências para os elementos da visualização
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Referências aos TextViews para exibir os dados do filme
        val txvDiretor = itemView.findViewById<TextView>(R.id.view_diretor)
        val txvFilmes = itemView.findViewById<TextView>(R.id.view_filme)
    }

    // Criação do ViewHolder e inflagem do layout para um item da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Infla o layout item_filme para ser usado pelo ViewHolder
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_filme, parent, false)
        // Retorna uma nova instância de ViewHolder com a visão inflada
        return ViewHolder(view)
    }

    // Liga os dados do filme à visualização no ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Obtém o filme da lista com base na posição
        val filme = listafilmes[position]
        // Define o texto dos TextViews com as informações do filme
        holder.txvDiretor.text = filme.diretor
        holder.txvFilmes.text = filme.titulo
    }

    // Retorna o número total de itens na lista
    override fun getItemCount(): Int {
        // Retorna o tamanho da lista de filmes
        return listafilmes.size
    }
}
