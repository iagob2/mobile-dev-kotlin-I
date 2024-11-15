package br.edu.fatecpg.consulta_facil.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.fatecpg.consulta_facil.adapter.ListaConsultasAdapter
import br.edu.fatecpg.consulta_facil.databinding.ActivityUsuarioBinding
import br.edu.fatecpg.consulta_facil.funcoes.buscaNomeESalvarConsulta
import br.edu.fatecpg.consulta_facil.model.Consulta

class PagUsuarioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUsuarioBinding
    private lateinit var consultasAdapter: ListaConsultasAdapter
    private val listaConsultas: MutableList<Consulta> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o layout com o binding
        binding = ActivityUsuarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configuração do RecyclerView
        consultasAdapter = ListaConsultasAdapter(listaConsultas)
        binding.recyclerUsuario.layoutManager = LinearLayoutManager(this)
        binding.recyclerUsuario.adapter = consultasAdapter

        val usuarioNome = intent.getStringExtra("usuarioNome") ?: ""

        binding.btnMarcaConsultar.setOnClickListener {
            val data = binding.edtData.text.toString().trim()
            val hora = binding.edtHorario.text.toString().trim()

            if (data.isEmpty() || hora.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Chama a função externa para buscar o médico e salvar a consulta
            buscaNomeESalvarConsulta(this, usuarioNome, data, hora) { consulta ->
                listaConsultas.add(consulta)
                consultasAdapter.notifyDataSetChanged()

                binding.edtData.text.clear()
                binding.edtHorario.text.clear()

            }
        }
    }
}
