package com.example.atividade08.view

import android.os.Bundle // Importa a classe Bundle para passar dados entre atividades.
import android.widget.Toast
import androidx.activity.viewModels // Importa a extensão para obter ViewModels no ciclo de vida da Activity.
import androidx.appcompat.app.AppCompatActivity // Importa a classe AppCompatActivity para suporte a recursos da ActionBar.
import com.example.atividade08.databinding.ActivityProfileBinding // Importa o binding gerado para ActivityProfile.
import com.example.atividade08.viewmodel.UserViewModel // Importa a classe UserViewModel.

class ProfileActivity : AppCompatActivity() {
    // Declaração do binding para acessar elementos da UI.
    private lateinit var binding: ActivityProfileBinding
    // Instância do ViewModel para gerenciar dados do usuário.
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Infla o layout da ActivityProfile e inicializa o binding.
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtém o ID do usuário passado através da Intent.
        val userId = intent.getIntExtra("USER_ID", -1)

        // Verifica se o ID do usuário é válido.
        if (userId != -1) {
            // Busca os dados do usuário no ViewModel usando o ID.
            viewModel.getUserById(userId) { user ->
                if (user != null) {
                    // Atualiza os campos de texto com as informações do usuário.
                    binding.edtName.setText(user.nome_completo) // Preenche o nome completo.
                    binding.edtEmail.setText(user.email) // Preenche o email.

                    // Configura o listener para o botão de atualização.
                    binding.btnUpdate.setOnClickListener {
                        val updatedName = binding.edtName.text.toString().trim()
                        val updatedEmail = binding.edtEmail.text.toString().trim()

                        if (updatedName.isNotEmpty() && updatedEmail.isNotEmpty()) {
                            val updatedUser = user.copy(
                                nome_completo = updatedName,
                                email = updatedEmail,
                                senha = user.senha // Mantém a senha antiga
                            )
                            viewModel.updateUser(updatedUser)
                            Toast.makeText(this, "Dados do usuário atualizados com sucesso.", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                        }
                    }


                    // Configura o listener para o botão de exclusão.
                    binding.btnDelete.setOnClickListener {
                        // Chama a função de exclusão no ViewModel.
                        viewModel.deleteUser(user)
                        Toast.makeText(this, "Usuario deletado.", Toast.LENGTH_SHORT).show()

                        finish() // Finaliza a atividade após a exclusão.
                    }
                }
            }
        }
    }
}
