package br.edu.fatecpg.consulta_facil.funcoes

import br.edu.fatecpg.consulta_facil.model.Consulta
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun carregarConsultas(callback: (List<Consulta>) -> Unit, onError: (String) -> Unit) {
    val db = Firebase.firestore

    db.collection("Consultas")
        .get()
        .addOnSuccessListener { result ->
            val listaConsultas = result.mapNotNull { document ->
                try {
                    // Cria uma consulta somente se todos os campos estiverem presentes
                    val paciente = document.getString("paciente") ?: return@mapNotNull null
                    val data = document.getString("data") ?: return@mapNotNull null
                    val hora = document.getString("hora") ?: return@mapNotNull null
                    Consulta(paciente, data, hora) // Retorna um objeto Consulta
                } catch (e: Exception) {
                    onError("Erro ao processar consulta: ${e.message}")
                    null // Ignora a consulta em caso de erro
                }
            }
            callback(listaConsultas) // Retorna a lista filtrada de consultas válidas
        }
        .addOnFailureListener { e ->
            onError(e.message ?: "Erro desconhecido")
        }
}
