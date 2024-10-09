package com.example.app01.model

/**
 * Data class que representa um usuário do sistema.
 * @param login String - Nome de usuário para login
 * @param senha String - Senha do usuário
 * @param bloqueado Boolean - Indica se o usuário está bloqueado (padrão é falso)
 * @param tentativas Int - Contador de tentativas de login incorretas (padrão é 0)
 */
data class Usuario(
    val login: String,
    val senha: String,
    var bloqueado: Boolean = false, // Atributo que indica se o usuário está bloqueado
    var tentativas: Int = 0         // Contador de tentativas de login incorretas
)
