package br.edu.fatecpg.listafilme.dao

import br.edu.fatecpg.listafilme.model.ListaF

interface ListaDaoFilmesInterface {
    fun obterFilmes(): List<ListaF>
    fun adcionarFilmes(filmes: ListaF)
}