package com.example.app01.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app01.R
import com.example.app01.model.Usuario

// Adapter que exibe uma lista de usuários no RecyclerView
class ListaUsuarioAdapter(private val listaUsuario: MutableList<Usuario>) :
    RecyclerView.Adapter<ListaUsuarioAdapter.ViewHolder>() {

    // ViewHolder que guarda a referência ao layout de cada item
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNome: TextView = itemView.findViewById(R.id.textNome) // Referência ao TextView do layout
    }

    // Inflando o layout de cada item da lista quando o ViewHolder é criado
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.usuario, parent, false)
        return ViewHolder(view)
    }

    // Vinculando os dados de cada item à interface
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val usuario = listaUsuario[position]
        holder.txvNome.text = usuario.login // Exibindo o login do usuário
    }

    // Retorna a quantidade de itens na lista
    override fun getItemCount(): Int {
        return listaUsuario.size
    }
}
