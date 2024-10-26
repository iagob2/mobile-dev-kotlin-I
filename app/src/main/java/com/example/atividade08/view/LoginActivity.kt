package com.example.atividade08.view


import android.content.Intent // Importa a classe Intent para iniciar outras atividades.
import android.os.Bundle // Importa a classe Bundle para passar dados entre atividades.
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels // Importa a extensão para obter ViewModels no ciclo de vida da Activity.
import androidx.appcompat.app.AppCompatActivity // Importa a classe AppCompatActivity para suporte a recursos da ActionBar.
import com.example.atividade08.databinding.ActivityLoginBinding // Importa o binding gerado para ActivityLogin.
import com.example.atividade08.view.RegisterActivity // Importa a classe RegisterActivity.
import com.example.atividade08.viewmodel.UserViewModel // Importa a classe UserViewModel.

class LoginActivity : AppCompatActivity() {
    // Declaração do binding para acessar elementos da UI.
    private lateinit var binding: ActivityLoginBinding
    // Instância do ViewModel para gerenciar dados relacionados ao usuário.
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Infla o layout da ActivityLogin e inicializa o binding.
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura o listener para o botão de login.
        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            try {
                viewModel.login(email, password) { user ->
                    if (user != null) {
                        val intent = Intent(this, ProfileActivity::class.java)
                        intent.putExtra("USER_ID", user.UserId)
                        Toast.makeText(this, "Bem-vindo.", Toast.LENGTH_SHORT).show()

                        startActivity(intent)

                    } else {
                        Toast.makeText(this, "Usuário não cadastrado ou senha incorreta.", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Erro durante o login. Tente novamente.", Toast.LENGTH_SHORT).show()
            }
        }


        // Configura o listener para o botão de cadastro.
        binding.btnCadastrar.setOnClickListener {
            // Inicia a RegisterActivity.
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent) // Inicia a nova atividade.
        }
    }
}