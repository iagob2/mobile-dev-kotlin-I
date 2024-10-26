package com.example.atividade08.viewmodel

import android.app.Application // Importa a classe Application para acessar o contexto da aplicação.
import androidx.lifecycle.AndroidViewModel // Importa a classe AndroidViewModel para gerenciar o ciclo de vida da UI.
import androidx.lifecycle.viewModelScope // Importa viewModelScope para realizar operações assíncronas.
import com.example.atividade08.database.AppDatabase // Importa a classe AppDatabase para acessar o banco de dados.
import com.example.atividade08.model.User // Importa o modelo User.
import kotlinx.coroutines.Dispatchers // Importa Dispatchers para definir o contexto da corrotina.
import kotlinx.coroutines.launch // Importa launch para iniciar corrotinas.
import kotlinx.coroutines.withContext

class UserViewModel(application: Application) : AndroidViewModel(application) {
    // Cria uma instância do UserDao usando o banco de dados
    private val userDao = AppDatabase.getDatabase(application).userDao()

    // Função para login do usuário
    fun login(email: String, senha: String, callback: (User?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = userDao.login(email, senha) // Chama o método de login no DAO
            withContext(Dispatchers.Main) {
                callback(user) // Retorna o usuário encontrado pelo callback no Main Thread
            }
        }
    }


    // Função para obter usuário pelo ID
    fun getUserById(userId: Int, callback: (User?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { // Executa em um contexto IO
            val user = userDao.getUserById(userId) // Busca o usuário pelo ID no DAO
            callback(user) // Retorna o usuário encontrado pelo callback
        }
    }

    // Função para registrar um novo usuário
    fun register(user: User, callback: (Boolean, String?) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) { // Executa em um contexto IO
            return@launch try {
                // Verifica se o usuário já está cadastrado
                val existingUser = user.email?.let { userDao.getUserByEmail(it) };
                if (existingUser != null) {
                    // Se já existir, retorna uma mensagem indicando que o usuário já está registrado
                    callback(false, "O usuário já está cadastrado com esse e-mail.")
                } else {
                    // Insere o usuário no banco de dados
                    userDao.insertUser(user)
                    // Chama o callback com sucesso
                    callback(true, "Usuário cadastrado com sucesso!")
                }
            } catch (e: Exception) {
                // Chama o callback com erro
                callback(false, e.message ?: "Erro ao cadastrar usuário.")
            }
        }
    }


    // Função para atualizar um usuário
    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) { // Executa em um contexto IO
            userDao.updateUser(user) // Atualiza o usuário no banco de dados
        }
    }

    // Função para deletar um usuário
    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) { // Executa em um contexto IO
            userDao.deleteUser(user) // Deleta o usuário do banco de dados
        }
    }
}
