package br.edu.fatecpg.produtos.dao

import android.widget.Toast
import br.edu.fatecpg.produtos.model.ListaP
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// Definindo uma função que carrega produtos e retorna via callback
fun carregarProdutos(callback: (List<ListaP>) -> Unit, onError: (String) -> Unit) {
    // Referência ao Firestore
    val db = Firebase.firestore

    // Lê documentos da coleção "Produtos"
    db.collection("Produtos")
        .get()
        .addOnSuccessListener { result ->
            val listaProdutos = mutableListOf<ListaP>() // Cria uma lista mutável temporária
            for (document in result) {
                val nome = document.getString("nome") ?: ""
                val categori = document.getString("categori") ?: ""
                val preco = document.getDouble("preco") ?: 0.0
                listaProdutos.add(ListaP(nome, categori, preco)) // Adiciona cada produto na lista
            }
            callback(listaProdutos) // Retorna a lista de produtos para o callback
        }
        .addOnFailureListener { e ->
            onError(e.message ?: "Erro desconhecido") // Retorna a mensagem de erro no callback onError
        }
}
