package br.edu.fatecpg.consulta_facil.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.consulta_facil.R
import br.edu.fatecpg.consulta_facil.model.Consulta

class ListaConsultasMedicoAdapter(private var listaConsultas: List<Consulta>) :
    RecyclerView.Adapter<ListaConsultasMedicoAdapter.ViewHolder>() {

    class ViewHolder(consultaView: View) : RecyclerView.ViewHolder(consultaView) {
        val txvNomePaciente: TextView = consultaView.findViewById(R.id.txt_nomeP)
        val txvData: TextView = consultaView.findViewById(R.id.txt_data)
        val txvHorario: TextView = consultaView.findViewById(R.id.txt_horario)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_agenda_consuta, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val consulta = listaConsultas[position]
        holder.txvData.text = consulta.data
        holder.txvHorario.text = consulta.hora
        holder.txvNomePaciente.text = consulta.paciente
    }

    override fun getItemCount(): Int {
        return listaConsultas.size
    }

    // Função para atualizar a lista de consultas e notificar o RecyclerView
    fun atualizarLista(novaLista: List<Consulta>) {
        listaConsultas = novaLista
        notifyDataSetChanged() // Notifica o RecyclerView sobre a atualização dos dados
    }
}
