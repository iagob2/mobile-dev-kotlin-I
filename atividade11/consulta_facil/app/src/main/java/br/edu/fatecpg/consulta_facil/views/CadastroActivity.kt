package br.edu.fatecpg.consulta_facil.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.consulta_facil.databinding.ActivityCastratoBinding
import br.edu.fatecpg.consulta_facil.model.Usuario
import br.edu.fatecpg.consulta_facil.funcoes.salvarUsuario
import com.google.firebase.FirebaseApp

class CadastroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCastratoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurar View Binding
        binding = ActivityCastratoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar o Firebase
        FirebaseApp.initializeApp(this)

        // Configurar RadioButtons para garantir que apenas um seja selecionado
        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                binding.radioP.id -> {
                    // Se "Paciente" for selecionado, desmarcar "Médico"
                    binding.radioM.isChecked = false
                }
                binding.radioM.id -> {
                    // Se "Médico" for selecionado, desmarcar "Paciente"
                    binding.radioP.isChecked = false
                }
            }
        }

        // Ação do botão de cadastrar
        binding.btnCadastro.setOnClickListener {
            val nome = binding.edNome.text.toString()
            val email = binding.edEmail.text.toString()
            val senha = binding.edSenha.text.toString()
            val isPaciente = binding.radioP.isChecked
            val isMedico = binding.radioM.isChecked

            // Validar campos
            if (nome.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty()) {
                // Criar objeto do usuário
                val usuario = Usuario(nome, email, senha, isMedico, isPaciente)

                // Chamar a função salvarUsuario e definir os callbacks de sucesso e erro
                salvarUsuario(usuario,
                    onSuccess = {
                        Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

                        // Limpar os campos após o sucesso do cadastro
                        binding.edNome.text.clear()
                        binding.edEmail.text.clear()
                        binding.edSenha.text.clear()
                        binding.radioP.isChecked = false
                        binding.radioM.isChecked = false
                    },
                    onError = { errorMsg ->
                        Toast.makeText(this, "Erro ao cadastrar: $errorMsg", Toast.LENGTH_SHORT).show()
                    }
                )
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        // Ação do botão de voltar para o login
        binding.btnVoltaLogin.setOnClickListener {
            finish() // Fecha a Activity atual e retorna para a anterior
        }
    }
}
