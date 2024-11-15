package br.edu.fatecpg.consulta_facil.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.consulta_facil.adapter.ListaConsultasMedicoAdapter
import br.edu.fatecpg.consulta_facil.databinding.ActivityPagMedicBinding
import br.edu.fatecpg.consulta_facil.funcoes.carregarConsultas
import br.edu.fatecpg.consulta_facil.model.Consulta

class PagMedicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPagMedicBinding
    private lateinit var listaConsultasMedicoAdapter: ListaConsultasMedicoAdapter
    private val listaConsultas: MutableList<Consulta> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagMedicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializa o adapter e atribui ao RecyclerView uma vez
        listaConsultasMedicoAdapter = ListaConsultasMedicoAdapter(listaConsultas)
        binding.recyclerMedico.adapter = listaConsultasMedicoAdapter

        carregarConsultas(
            callback = { consultas ->
                listaConsultas.clear()
                listaConsultas.addAll(consultas)
                listaConsultasMedicoAdapter.notifyDataSetChanged() // Notifica o RecyclerView sobre os novos dados
            },
            onError = { erro ->
                Toast.makeText(this, "Erro ao carregar consultas: $erro", Toast.LENGTH_LONG).show()
            }
        )
    }
}
