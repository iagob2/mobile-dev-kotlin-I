package br.edu.fatecpg.consulta_facil.dao

import br.edu.fatecpg.consulta_facil.model.Usuario

class ListaUsuario:ListaAgendaConsulta{

    companion object {
        private val usuario = mutableListOf<Usuario>()
    }

    override fun obterUsuarios(): MutableList<Usuario> {
        return Companion.usuario
    }

    override fun adcinarUsuario(usario: Usuario) {
        Companion.usuario.add(usario)
    }


}