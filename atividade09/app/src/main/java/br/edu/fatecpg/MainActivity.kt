package br.edu.fatecpg

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance() // Inicialize o Firebase Auth corretamente

        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            val senha = binding.edtPassword.text.toString().trim()

            if (email.isNotEmpty() && senha.isNotEmpty()) {
                auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Sucesso", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, TerceiraActivity::class.java)
                        intent.putExtra("email",email)
                        startActivity(intent)
                    } else {
                        val errorMessage = task.exception?.message ?: "Erro desconhecido"
                        Toast.makeText(this, "Erro: $errorMessage", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnCadastrar.setOnClickListener {
            val intent = Intent(this, SegundaActivity::class.java)
            startActivity(intent)
        }
    }
}
