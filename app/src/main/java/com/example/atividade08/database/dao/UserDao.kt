package com.example.atividade08.database.dao

import androidx.room.* // Importa as anotações do Room para a criação do DAO.
import com.example.atividade08.model.User // Importa a classe User que representa o modelo de dados.

@Dao // Indica que esta interface é um Data Access Object (DAO) do Room.
interface UserDao {

    @Query("SELECT * FROM Usuario") // Consulta para buscar todos os usuários da tabela "Usuario".
    suspend fun getAll(): List<User> // Método suspenso que retorna uma lista de usuários.

    @Query("SELECT * FROM Usuario WHERE email = :email AND senha = :senha") // Consulta para fazer login, verificando email e senha.
    suspend fun login(email: String, senha: String): User? // Método suspenso que retorna um usuário ou null se não encontrado.

    @Query("SELECT * FROM Usuario WHERE UserId = :userId") // Consulta para buscar um usuário específico pelo ID.
    suspend fun getUserById(userId: Int): User? // Método suspenso que retorna um usuário ou null se não encontrado.

    @Query("SELECT EMAIL FROM USUARIO WHERE EMAIL =:emailUsuario")
    suspend fun getUserByEmail(emailUsuario:String): String?

    @Insert(onConflict = OnConflictStrategy.REPLACE) // Método para inserir um novo usuário no banco de dados.
    suspend fun insertUser(user: User) // Método suspenso que insere um usuário. Substitui o existente em caso de conflito.

    @Update // Método para atualizar um usuário existente.
    suspend fun updateUser(user: User) // Método suspenso que atualiza os dados de um usuário.

    @Delete // Método para excluir um usuário do banco de dados.
    suspend fun deleteUser(user: User) // Método suspenso que remove um usuário do banco de dados.
}
