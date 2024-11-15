package br.edu.fatecpg.consulta_facil.funcoes

import android.content.Context
import android.widget.Toast
import br.edu.fatecpg.consulta_facil.model.Consulta
import com.google.firebase.firestore.FirebaseFirestore

// Função para buscar médico e salvar consulta em um arquivo separado
fun buscaNomeESalvarConsulta(
    context: Context,
    usuarioNome: String,
    data: String,
    hora: String,
    onConsultaSalva: (Consulta) -> Unit
) {
    val db = FirebaseFirestore.getInstance()

    db.collection("Usuarios")
        .whereEqualTo("isPaciente", true)
        .get()
        .addOnSuccessListener { documents ->
            if (documents.isEmpty) {
                Toast.makeText(context, "paciente não  encontrado", Toast.LENGTH_SHORT).show()
            } else {
                // Chama a função para salvar a consulta
                salvarConsulta(context, usuarioNome, data, hora)

                // Cria o objeto Consulta e chama o callback para atualizar a lista
                val consulta = Consulta(usuarioNome, data, hora)
                onConsultaSalva(consulta)
            }
        }
        .addOnFailureListener { e ->
            Toast.makeText(context, "Erro ao buscar paciente: ${e.message}", Toast.LENGTH_SHORT).show()
        }
}
