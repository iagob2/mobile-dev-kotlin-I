// FuncoesUtils.kt
package br.edu.fatecpg.consulta_facil.funcoes

import br.edu.fatecpg.consulta_facil.model.Usuario
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

fun salvarUsuario(usuario: Usuario, onSuccess: () -> Unit, onError: (String) -> Unit) {
    val db = Firebase.firestore

    val usuarioMap = mapOf(
        "nome" to usuario.nome,
        "email" to usuario.email,
        "senha" to usuario.senha,
        "isMedico" to usuario.isMedico,
        "isPaciente" to usuario.isPaciente
    )

    db.collection("Usuarios")
        .add(usuarioMap)
        .addOnSuccessListener { onSuccess() }
        .addOnFailureListener { e ->
            onError(e.message ?: "Erro desconhecido ao salvar usuário")
        }
}
