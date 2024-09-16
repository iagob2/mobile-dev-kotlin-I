package com.example.listadetarefas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.listadetarefas.R
import com.example.listadetarefas.model.ListaT

class AdapterListaTarefas (private val listatarefas:List<ListaT>):
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
        holder.txvDescri.text = item.descrição
        holder.txvNome.text = item.nomeTarefa

        /// Listener para mudar o estado quando o RadioButton é clicado
        holder.radioFeito.setOnCheckedChangeListener { _, isChecked ->
            item.foiFeita = isChecked  // Atualize o estado da tarefa

            // Exibe o Toast ao marcar/desmarcar a tarefa
            if (isChecked) {
                Toast.makeText(holder.itemView.context, "${item.nomeTarefa} foi feita!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(holder.itemView.context, "${item.nomeTarefa} não foi feita!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
     return listatarefas.size
    }


}
