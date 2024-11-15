package br.edu.fatecpg.consulta_facil.model

import android.provider.ContactsContract.CommonDataKinds.Email

data class Usuario(
    val nome: String = "",
    val email: String = "",
    val senha: String = "",
    val isMedico: Boolean = false,
    val isPaciente: Boolean = false
)

