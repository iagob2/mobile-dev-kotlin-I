package com.example.atividade08.database

import android.content.Context // Importa a classe Context do Android para acessar o ambiente da aplicação.
import androidx.room.Database // Importa a anotação Database para definir a classe como uma base de dados Room.
import androidx.room.Room // Importa a classe Room para construir a instância do banco de dados.
import androidx.room.RoomDatabase // Importa a classe RoomDatabase, que é a superclasse para todas as bases de dados Room.
import com.example.atividade08.database.dao.UserDao // Importa a interface UserDao para operações com usuários.
import com.example.atividade08.model.User // Importa o modelo User que será armazenado no banco de dados.

@Database(entities = [User::class], version = 1) // Define a classe como uma base de dados com a entidade User e versão 1.
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao // Função abstrata que retorna uma instância de UserDao para operações de banco de dados.

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null // Instância do banco de dados, marcada como volátil para evitar inconsistências.

        fun getDatabase(context: Context): AppDatabase { // Função que retorna a instância do banco de dados.
            return INSTANCE ?: synchronized(this) { // Usa synchronized para garantir que apenas uma thread possa acessar o bloco de código a seguir.
                val instance = Room.databaseBuilder( // Cria uma instância do banco de dados usando o Room.
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user_database" // Nome do banco de dados.
                ).build() // Constrói a instância do banco de dados.
                INSTANCE = instance // Armazena a instância criada para uso futuro.
                instance // Retorna a instância do banco de dados.
            }
        }
    }
}
