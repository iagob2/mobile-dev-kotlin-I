package com.example.app01.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.app01.databinding.ActivityLoginBinding
import com.example.app01.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private val viewModel = LoginViewModel()
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Botão "Entrar" chama o ViewModel para realizar a ação de login (tipo 1)
        binding.btnEntre.setOnClickListener {
            val login = binding.edtLogin.text.toString().trim()
            val senha = binding.edtPasse.text.toString().trim()

            val result  = viewModel.realizarAcao(login, senha, 1) // 1 indica login

            if (result) {
                viewModel.mostrarMensagem(this,1,result)
                // Navega para a SegundaActivity se o login for bem-sucedido
                val intent = Intent(this, SegundaActivity::class.java)
                startActivity(intent)
            } else {
                // Mostra uma mensagem de erro
                viewModel.mostrarMensagem(this,1,result)

            }
        }

        // Botão "Cadastrar" chama o ViewModel para realizar a ação de cadastro (tipo 0)
        binding.btnCadastrar.setOnClickListener {
            val login = binding.edtLogin.text.toString().trim()
            val senha = binding.edtPasse.text.toString().trim()

            val result = viewModel.realizarAcao(login, senha, 0) // 0 indica cadastro
            viewModel.mostrarMensagem(this,0,result)


        }
    }
}
