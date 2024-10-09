package com.example.app01.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.app01.model.Usuario

class LoginViewModel : ViewModel() {
    companion object {
        // Lista estática que armazena os usuários cadastrados
        private val usuarios = mutableListOf<Usuario>()
    }

    /**
     * Função para retornar a lista de usuários cadastrados.
     * @return MutableList<Usuario> - Lista de usuários
     */
    fun mostrarUsuario(): MutableList<Usuario> {
        return usuarios
    }

    /**
     * Exibe uma mensagem na forma de Toast.
     * @param context Context - Contexto da aplicação necessário para o Toast
     * @param msm String - Mensagem a ser exibida
     */
    fun mostrarMensagem(context: Context, msm: String) {
        Toast.makeText(context, msm, Toast.LENGTH_LONG).show()
    }

    /**
     * Função que realiza login ou cadastro, retornando um Pair<Boolean, String>
     * @param login String - Nome de usuário
     * @param senha String - Senha do usuário
     * @param tipoAcao Int - 1 para login, 0 para cadastro
     * @return Pair<Boolean, String> - Resultado da operação (true para sucesso) e mensagem correspondente
     */
    fun realizarAcao(login: String, senha: String, tipoAcao: Int): Pair<Boolean, String> {
        // Validação dos campos de entrada
        if (login.isEmpty() || senha.isEmpty()) {
            return Pair(false, "Preencha todos os campos!") // Retorna erro se algum campo estiver vazio
        }

        val user = Usuario(login, senha)

        // Realiza login (tipoAcao == 1) ou cadastro (tipoAcao == 0)
        return if (tipoAcao == 1) {
            val mensagem = logar(user)
            Pair(mensagem == "Login realizado com sucesso", mensagem)
        } else {
            val mensagem = cadastrar(user)
            Pair(mensagem == "Cadastrado com sucesso", mensagem)
        }
    }

    /**
     * Função de login que verifica se o usuário existe e se a senha está correta.
     * @param user Usuario - Objeto que representa o usuário tentando logar
     * @return String - Mensagem do resultado da operação de login
     */
    private fun logar(user: Usuario): String {
        // Busca o usuário na lista de cadastrados
        val retorno = usuarios.find { it.login == user.login }

        // Verifica se o usuário existe ou se está bloqueado
        if (retorno == null || retorno.bloqueado) {
            return if (retorno?.bloqueado == true) {
                "Usuário bloqueado!"
            } else {
                "Login inválido!"
            }
        }

        // Verifica se a senha está correta
        return if (retorno.senha == user.senha) {
            retorno.tentativas = 0 // Reseta o contador de tentativas após login bem-sucedido
            "Login realizado com sucesso"
        } else {
            retorno.tentativas++ // Incrementa as tentativas de login incorreto

            // Bloqueia o usuário se o limite de tentativas for excedido
            if (retorno.tentativas >= 3) {
                retorno.bloqueado = true
                "Usuário bloqueado por excesso de tentativas!"
            } else {
                "Senha incorreta! Tentativas: ${retorno.tentativas}/3"
            }
        }
    }

    /**
     * Função de cadastro que verifica se o usuário já está cadastrado.
     * @param user Usuario - Objeto que representa o usuário a ser cadastrado
     * @return String - Mensagem do resultado da operação de cadastro
     */
    private fun cadastrar(user: Usuario): String {
        // Verifica se o usuário já está cadastrado
        val retorno = usuarios.find { it.login == user.login }
        return if (retorno == null) {
            usuarios.add(user) // Adiciona o novo usuário à lista
            "Cadastrado com sucesso"
        } else {
            "Usuário já cadastrado ou campos vazios" // Retorna erro se o usuário já existir
        }
    }
}
