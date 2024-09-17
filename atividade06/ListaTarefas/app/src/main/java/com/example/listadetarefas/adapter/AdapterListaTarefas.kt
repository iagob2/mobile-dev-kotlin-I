package com.example.listadetarefas.adapter

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefas.R
import com.example.listadetarefas.model.ListaT

class AdapterListaTarefas (private val listatarefas:MutableList<ListaT>):
    RecyclerView.Adapter<AdapterListaTarefas.ViewHolder>() {

        class  ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
            val txvNome = itemView.findViewById<TextView>(R.id.textNome);
            val txvDescri = itemView.findViewById<TextView>(R.id.textDescrit);
            val radioFeito = itemView.findViewById<RadioButton>(R.id.radioTarefaFeita);

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.itens,parent,false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listatarefas[position]

        // Setando o nome e a descrição
        holder.txvDescri.text = item.descrição
        holder.txvNome.text = item.nomeTarefa

        // Configura o estado do RadioButton com base na tarefa (true se foi feita)
        holder.radioFeito.isChecked = item.foiFeita

        // Listener para mudar o estado quando o RadioButton é clicado
        holder.radioFeito.setOnCheckedChangeListener { _, isChecked ->
            item.foiFeita = isChecked  // Atualize o estado da tarefa

            if (isChecked) {
                // Exibe o Toast ao marcar a tarefa como feita
                Toast.makeText(holder.itemView.context, "${item.nomeTarefa} foi feita!", Toast.LENGTH_SHORT).show()

                // Handler para remover o item após 3 segundos
                Handler(Looper.getMainLooper()).postDelayed({
                    // Remova o item da lista
                    listatarefas.removeAt(position)
                    // Notifique o Adapter que o item foi removido
                    notifyItemRemoved(position)
                    notifyItemRangeChanged(position, listatarefas.size)
                }, 3000)  // 3000 milissegundos = 3 segundos
            }
        }
    }

    override fun getItemCount(): Int {
     return listatarefas.size
    }


}
