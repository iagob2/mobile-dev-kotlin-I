package br.edu.fatecpg.consulta_facil.funcoes

import android.content.Context
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

// Modificando a função para receber o contexto como parâmetro
fun salvarConsulta(context: Context, paciente: String, data: String, hora: String) {
    val db = FirebaseFirestore.getInstance()
    val consulta = hashMapOf(
        "paciente" to paciente,
        "data" to data,
        "hora" to hora
    )

    db.collection("Consultas")
        .add(consulta)
        .addOnSuccessListener {
            // Sucesso ao salvar consulta
            Toast.makeText(context, "Consulta marcada com sucesso!", Toast.LENGTH_SHORT).show()
        }
        .addOnFailureListener { e ->
            Toast.makeText(context, "Erro ao marcar consulta: ${e.message}", Toast.LENGTH_SHORT).show()
        }
}
