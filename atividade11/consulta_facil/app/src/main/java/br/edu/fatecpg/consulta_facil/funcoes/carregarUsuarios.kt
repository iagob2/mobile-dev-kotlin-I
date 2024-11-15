package br.edu.fatecpg.consulta_facil.funcoes

import br.edu.fatecpg.consulta_facil.model.Usuario
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

// Função que carrega os usuários e retorna via callback
fun carregarUsuarios(callback: (List<Usuario>) -> Unit, onError: (String) -> Unit) {
    val db = Firebase.firestore

    // Lê documentos da coleção "Usuarios"
    db.collection("Usuarios")
        .get()
        .addOnSuccessListener { result ->
            val listaUsuarios = mutableListOf<Usuario>()
            for (document in result) {
                try {
                    val nome = document.getString("nome") ?: ""
                    val email = document.getString("email") ?: ""
                    val senha = document.getString("senha") ?: ""
                    val isMedico = document.getBoolean("isMedico") ?: false
                    val isPaciente = document.getBoolean("isPaciente") ?: false

                    // Cria o objeto Usuario e adiciona à lista
                    val usuario = Usuario(nome, email, senha, isMedico, isPaciente)
                    listaUsuarios.add(usuario)
                } catch (e: Exception) {
                    onError("Erro ao processar usuário: ${e.message}")
                }
            }
            callback(listaUsuarios) // Retorna a lista de usuários para o callback
        }
        .addOnFailureListener { e ->
            onError(e.message ?: "Erro desconhecido") // Retorna a mensagem de erro no callback onError
        }
}
