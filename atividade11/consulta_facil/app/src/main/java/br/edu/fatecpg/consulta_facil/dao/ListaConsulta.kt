package br.edu.fatecpg.consulta_facil.dao

import br.edu.fatecpg.consulta_facil.dao.ListaUsuario.Companion
import br.edu.fatecpg.consulta_facil.model.Consulta
import br.edu.fatecpg.consulta_facil.model.Usuario

class ListaConsulta:IntefaceListaConsulta {

    companion object {
        private val consulta = mutableListOf<Consulta>()
    }

    override fun obterConsultas(): MutableList<Consulta> {
        return ListaConsulta.consulta
    }

    override fun adcinarConsulta(consulta: Consulta) {
        Companion.consulta.add(consulta)
    }
}