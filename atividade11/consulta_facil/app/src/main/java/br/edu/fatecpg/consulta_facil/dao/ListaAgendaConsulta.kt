package br.edu.fatecpg.consulta_facil.dao

import br.edu.fatecpg.consulta_facil.model.Usuario

interface ListaAgendaConsulta {
    fun obterUsuarios(): MutableList<Usuario>

    fun adcinarUsuario(usario:Usuario)


}