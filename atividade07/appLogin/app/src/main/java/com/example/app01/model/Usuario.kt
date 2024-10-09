package com.example.app01.model
data class Usuario(
    val login: String,
    val senha: String,
    var bloqueado: Boolean = false, // Atributo que indica se o usuário está bloqueado
    var tentativas: Int = 0          // Contador de tentativas de login incorretas
)
