package br.edu.fatecpg.consulta_facil.funcoes


import android.content.Context
import android.content.Intent
import android.widget.Toast
import br.edu.fatecpg.consulta_facil.views.PagMedicActivity
import br.edu.fatecpg.consulta_facil.views.PagUsuarioActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore

// Função para verificar o usuário no banco de dados
fun verificarUsuario(email: String, senha: String, context: Context) {
    val db = Firebase.firestore

    // Realiza a consulta no Firestore para encontrar o usuário com o e-mail e senha fornecidos
    db.collection("Usuarios")
        .whereEqualTo("email", email) // Filtra pelo email
        .whereEqualTo("senha", senha) // Filtra pela senha
        .get()
        .addOnSuccessListener { documents ->
            // Verifica se há documentos retornados (usuário encontrado)
            if (documents.isEmpty) {
                Toast.makeText(context, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
            } else {
                // Obtém o primeiro documento retornado (usuário)
                val usuario = documents.documents[0]

                // Verifique se o usuário tem os dados de tipo
                val isMedico = usuario.getBoolean("isMedico") ?: false
                val isPaciente = usuario.getBoolean("isPaciente") ?: false
                val usuarioNome = usuario.getString("nome") ?: ""

                // Redireciona para a atividade apropriada com base no tipo de usuário
                when {
                    isMedico -> {
                        val intent = Intent(context, PagMedicActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        intent.putExtra("usuarioNome", usuarioNome)
                        context.startActivity(intent)
                    }
                    isPaciente -> {
                        val intent = Intent(context, PagUsuarioActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        intent.putExtra("usuarioNome", usuarioNome)
                        context.startActivity(intent)
                    }
                    else -> {
                        Toast.makeText(context, "Tipo de usuário não identificado", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        .addOnFailureListener { e ->
            Toast.makeText(context, "Erro ao buscar usuário: ${e.message}", Toast.LENGTH_SHORT).show()
        }
}
