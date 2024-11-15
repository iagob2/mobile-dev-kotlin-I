package br.edu.fatecpg.consulta_facil.dao

import br.edu.fatecpg.consulta_facil.model.Consulta

interface IntefaceListaConsulta {
    fun obterConsultas(): MutableList<Consulta>

    fun adcinarConsulta(consulta: Consulta)
}