package br.edu.fatecpg.consulta_facil.model

data class Consulta(
    val paciente: String,  // ID do paciente que marcou a consulta
    val data: String,        // Data da consulta
    val hora: String         // Hora da consulta
)
