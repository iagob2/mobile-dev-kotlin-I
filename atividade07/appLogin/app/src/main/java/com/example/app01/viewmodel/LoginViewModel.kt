package com.example.app01.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.app01.model.Usuario

class LoginViewModel : ViewModel() {
    companion object {
    private val usuarios = mutableListOf<Usuario>()
    }

    fun mostrarUsuario(): MutableList<Usuario> {
        return usuarios

    }

    // toast
    fun mostrarMensagem(context: Context, tipoAcao: Int, result: Boolean){

        if(tipoAcao == 0 ) {
            // Mostra uma mensagem (Toast) com o resultado da operação
            if (result) {
                Toast.makeText(context, "Cadastrado com sucesso", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(context, "Usuário já cadastrado ou campos vazios", Toast.LENGTH_LONG).show()
            }
        }else {
            if (result) {
                Toast.makeText(context, "Bem-vindo", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(context, "Login inválido ou campos vazios", Toast.LENGTH_LONG).show()
            }

        }
    }

    // Função que realiza a ação de login ou cadastro, dependendo do tipoAcao (1 para login, 0 para cadastro)
    fun realizarAcao(login: String, senha: String, tipoAcao: Int): Boolean {
        // Verifica se os campos estão vazios
        if (login.isEmpty() || senha.isEmpty()) {
            return false // Login ou senha vazios
        }

        // Cria o objeto Usuario
        val user = Usuario(login, senha)

        // Se tipoAcao for 1, tenta logar; se for 0, tenta cadastrar
        return if (tipoAcao == 1) {
            logar(user) == "Login realizado com sucesso"
        } else {
            cadastrar(user) == "Cadastrado com sucesso"
        }
    }

    // Função de login
    private fun logar(user: Usuario): String {
        // Encontra o usuário na lista
        val retorno = usuarios.find { it.login == user.login }

        // Se o usuário não existe, ou está bloqueado, retorna erro
        if (retorno == null || retorno.bloqueado) {
            return if (retorno?.bloqueado == true) {
                "Usuário bloqueado!"
            } else {
                "Login inválido!"
            }
        }

        // Verifica se a senha está correta
        return if (retorno.senha == user.senha) {
            // Resetar tentativas se o login for bem-sucedido
            retorno.tentativas = 0
            "Login realizado com sucesso"
        } else {
            // Incrementa o contador de tentativas se a senha estiver incorreta
            retorno.tentativas++

            // Bloqueia o usuário se ele errar a senha 3 vezes
            if (retorno.tentativas >= 3) {
                retorno.bloqueado = true
                "Usuário bloqueado por excesso de tentativas!"
            } else {
                "Senha incorreta! Tentativas: ${retorno.tentativas}/3"
            }
        }
    }

    // Função de cadastro
    private fun cadastrar(user: Usuario): String {
        val retorno = usuarios.find { it.login == user.login && it.senha == user.senha }
        return if (retorno == null) {
            usuarios.add(user)
            "Cadastrado com sucesso"
        } else {
            "Usuário já cadastrado"
        }
    }



}
