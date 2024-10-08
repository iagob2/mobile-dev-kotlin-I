package com.example.app01.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app01.databinding.ActivityLoginBinding
import com.example.app01.model.Usuario
import com.example.app01.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    // Criamos a parte que vai cuidar do login e cadastro
    private val viewModel = LoginViewModel()

    // Usamos o binding para acessar os elementos da tela (como botões e campos de texto)
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Aqui "inflamos" o layout para conectar o código com a tela de login
        binding = ActivityLoginBinding.inflate(layoutInflater)

        // Define qual layout usar, que é o da tela de login
        setContentView(binding.root)

        // Quando o botão de "Entrar" for clicado, tentamos logar o usuário (1 para login)
        binding.btnEntre.setOnClickListener {
            realizarAcao(1) // 1 significa que é para fazer login
            
        }

        // Quando o botão de "Cadastrar" for clicado, tentamos cadastrar o usuário (0 para cadastro)
        binding.btnCadastrar.setOnClickListener {
            realizarAcao(0) // 0 significa que é para fazer cadastro
        }
    }

    // Função que realiza a ação de login ou cadastro, dependendo do que o usuário clicou
    private fun realizarAcao(tipoAcao: Int) {
        // Pega o texto do campo de login (o que o usuário digitou)
        val login = binding.edtLogin.text.toString().trim()

        // Pega o texto do campo de senha (o que o usuário digitou)
        val senha = binding.edtPasse.text.toString().trim()

        // Verifica se os campos estão vazios
        if (login.isEmpty() || senha.isEmpty()) {
            // Mostra uma mensagem se o login ou senha estiverem vazios
            Toast.makeText(this, "Login e senha não podem estar vazios", Toast.LENGTH_SHORT).show()
            return
        }

        // Cria um objeto do tipo "Usuario" com as informações que o usuário digitou
        val user = Usuario(login, senha)

        // Se tipoAcao for 1, faz login. Se for 0, faz cadastro
        val resultado = if (tipoAcao == 1) {
            viewModel.logar(user)
        } else {
            viewModel.cadastrar(user)
        }

        // Mostra uma mensagem (Toast) com o resultado da operação
        Toast.makeText(this, resultado, Toast.LENGTH_LONG).show()
    }
}
