package com.example.atividade08.model

import androidx.room.ColumnInfo // Importa a anotação ColumnInfo para definir o nome das colunas.
import androidx.room.Entity // Importa a anotação Entity para marcar a classe como uma entidade do banco de dados.
import androidx.room.PrimaryKey // Importa a anotação PrimaryKey para definir a chave primária.

@Entity(tableName = "Usuario") // Define a classe como uma entidade do Room com o nome da tabela "Usuario".
data class User(
    @PrimaryKey(autoGenerate = true) val UserId: Int = 0, // Define a chave primária da entidade, com auto incremento.
    @ColumnInfo(name = "nome_completo") val nome_completo: String?, // Define a coluna "nome_completo" na tabela.
    @ColumnInfo(name = "email") val email: String?, // Define a coluna "email" na tabela.
    @ColumnInfo(name = "senha") val senha: String? // Define a coluna "senha" na tabela.
)
