package br.edu.fatecpg.consulta_facil.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.consulta_facil.R
import br.edu.fatecpg.consulta_facil.model.Consulta
import com.google.firebase.firestore.FirebaseFirestore

class ListaConsultasAdapter(private val listaConsultas: MutableList<Consulta>) :
    RecyclerView.Adapter<ListaConsultasAdapter.ViewHolder>() {


    class ViewHolder(consultaView: View) : RecyclerView.ViewHolder(consultaView) {
        val txvData: TextView = consultaView.findViewById(R.id.txt_data)
        val txvHorario: TextView = consultaView.findViewById(R.id.txt_horario)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_conultas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val consulta = listaConsultas[position]

        holder.txvData.text = consulta.data
        holder.txvHorario.text = consulta.hora
    }

    override fun getItemCount(): Int {
        return listaConsultas.size
    }
}
