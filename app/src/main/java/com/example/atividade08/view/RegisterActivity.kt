package com.example.atividade08.view

import android.content.Intent // Importa a classe Intent para navegação entre atividades.
import android.os.Bundle // Importa a classe Bundle para passar dados entre atividades.
import android.widget.Toast // Importa a classe Toast para exibir mensagens breves.
import androidx.activity.viewModels // Importa a extensão para obter ViewModels no ciclo de vida da Activity.
import androidx.appcompat.app.AppCompatActivity // Importa a classe AppCompatActivity para suporte a recursos da ActionBar.
import com.example.atividade08.databinding.ActivityRegisterBinding // Importa o binding gerado para ActivityRegister.
import com.example.atividade08.model.User // Importa a classe User.
import com.example.atividade08.viewmodel.UserViewModel // Importa a classe UserViewModel.

class RegisterActivity : AppCompatActivity() {
    // Declaração do binding para acessar elementos da UI.
    private lateinit var binding: ActivityRegisterBinding
    // Instância do ViewModel para gerenciar dados do usuário.
    private val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Infla o layout da ActivityRegister e inicializa o binding.
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura o listener para o botão de registro.
        binding.btnCadastrar.setOnClickListener {
            // Obtém os valores dos campos de entrada.
            val name = binding.edtName.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            // Verifica se todos os campos estão preenchidos.
            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                // Cria uma nova instância de User com os dados informados.
                val user = User(nome_completo = name, email = email, senha = password)

                // Função para registrar o usuário no ViewModel.
                userViewModel.register(user) { success, message ->
                    if (success) {
                        // Exibe mensagem de sucesso e navega para a LoginActivity.
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent) // Inicia a LoginActivity.

                        finish() // Finaliza a RegisterActivity.
                    } else {
                        // Exibe mensagem de erro.
                        Toast.makeText(this, message ?: "Erro ao cadastrar usuário.", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                // Exibe mensagem pedindo para preencher todos os campos.
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        // Configura o listener para o botão de login.
        binding.btnLogin.setOnClickListener {
            // Inicia a LoginActivity ao clicar no botão de login.
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent) // Inicia a LoginActivity.
            finish() // Finaliza a RegisterActivity.
        }
    }
}
