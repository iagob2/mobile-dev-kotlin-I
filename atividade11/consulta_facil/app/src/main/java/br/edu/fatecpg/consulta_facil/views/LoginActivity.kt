package br.edu.fatecpg.consulta_facil.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import br.edu.fatecpg.consulta_facil.databinding.ActivityMainBinding
import br.edu.fatecpg.consulta_facil.funcoes.verificarUsuario

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurar View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIrCadastro.setOnClickListener {
            // Corrigir o nome da classe para a tela de cadastro
            val intent = Intent(this, CadastroActivity::class.java)  // Certifique-se de que CadastroActivity existe
            startActivity(intent)
        }

        // Ação do botão de login
        binding.btnLogin.setOnClickListener {
            val email = binding.edEmail.text.toString().trim()
            val senha = binding.edSenha.text.toString().trim()

            // Verificar se os campos de email e senha não estão vazios
            if (email.isNotEmpty() && senha.isNotEmpty()) {
                // Chama a função para verificar o usuário, passando o email, senha e contexto
                verificarUsuario(email, senha, this)
            } else {
                // Exibe uma mensagem caso algum campo não tenha sido preenchido
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }

            // Limpar os campos de email e senha após a tentativa de login
            binding.edEmail.text.clear()
            binding.edSenha.text.clear()
        }
    }
}
