package br.edu.fatecpg.produtos.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.produtos.databinding.ActivityMainBinding
import br.edu.fatecpg.produtos.model.ListaP
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar o Firebase
        FirebaseApp.initializeApp(this)
        val db = Firebase.firestore

        // Navegar para a segunda activity (exibir lista de produtos)
        binding.btn2.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        // Ação do botão de cadastrar
        binding.btnCadastrar.setOnClickListener {
            val nome = binding.edtnome.text.toString()
            val categori = binding.edtCategoria.text.toString()
            val preco = binding.edtPreco.text.toString().toDoubleOrNull()

            if (nome.isNotEmpty() && categori.isNotEmpty() && preco != null) {
                val produto = ListaP(nome, categori, preco)


                // Adicionar produto ao Firestore
                db.collection("Produtos")
                    .add(produto)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "Erro ao salvar: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos corretamente.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
