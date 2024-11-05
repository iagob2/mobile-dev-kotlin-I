package br.edu.fatecpg

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.databinding.ActivitySegundaBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class SegundaActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySegundaBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegundaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance() // Use getInstance() para inicializar

        binding.btnCadastrar.setOnClickListener {
            val nome = binding.edtName.text.toString().trim()
            val email = binding.edtEmail.text.toString().trim()
            val senha = binding.edtPassword.text.toString().trim()

            if (nome.isNotEmpty() && email.isNotEmpty() && senha.isNotEmpty()) {
                // Criar um novo usuário
                auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val userId = auth.currentUser?.uid
                        val database = FirebaseDatabase.getInstance().getReference("users")

                        userId?.let {
                            // Salvar nome no Firebase Realtime Database
                            database.child(it).setValue(nome).addOnCompleteListener { dbTask ->
                                if (dbTask.isSuccessful) {
                                    Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                                    finish() // Fecha a SegundaActivity
                                } else {
                                    Toast.makeText(this, "Erro ao salvar nome: ${dbTask.exception?.message}", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    } else {
                        // Exibe mensagem de erro
                        val errorMessage = task.exception?.message ?: "Erro desconhecido"
                        Toast.makeText(this, "Erro: $errorMessage", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
