package com.example.app01.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app01.databinding.ActivityLoginBinding
import com.example.app01.viewmodel.LoginViewModel

/**
 * Classe responsável por gerenciar a Activity de Login.
 * Utiliza ViewModel para realizar operações de login e cadastro.
 */
class LoginActivity : AppCompatActivity() {

    // Inicializa o ViewModel para gerenciar as regras de negócio da Activity
    private val viewModel = LoginViewModel()

    // Binding da Activity, responsável por conectar os elementos da interface com o código
    private lateinit var binding: ActivityLoginBinding

    /**
     * Função chamada quando a Activity é criada.
     * Responsável por configurar a interface e os listeners dos botões.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout da Activity usando ViewBinding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Listener para o botão "Entrar" (login)
        binding.btnEntre.setOnClickListener {
            // Obtém os valores de login e senha digitados pelo usuário
            val login = binding.edtLogin.text.toString().trim()
            val senha = binding.edtPasse.text.toString().trim()

            // Chama a função realizarAcao do ViewModel, passando os dados e tipo 1 para login
            val (result, mensagem) = viewModel.realizarAcao(login, senha, 1) // tipo 1 = login

            // Exibe a mensagem retornada (usando um Toast) pelo ViewModel
            viewModel.mostrarMensagem(this, mensagem)

            // Se o login for bem-sucedido, navega para a SegundaActivity
            if (result) {
                val intent = Intent(this, SegundaActivity::class.java)
                startActivity(intent)
            }
        }

        // Listener para o botão "Cadastrar" (cadastro)
        binding.btnCadastrar.setOnClickListener {
            // Obtém os valores de login e senha digitados pelo usuário
            val login = binding.edtLogin.text.toString().trim()
            val senha = binding.edtPasse.text.toString().trim()

            // Chama a função realizarAcao do ViewModel, passando os dados e tipo 0 para cadastro
            val (result, mensagem) = viewModel.realizarAcao(login, senha, 0) // tipo 0 = cadastro

            // Exibe a mensagem retornada pelo ViewModel
            viewModel.mostrarMensagem(this, mensagem)
        }
    }
}
