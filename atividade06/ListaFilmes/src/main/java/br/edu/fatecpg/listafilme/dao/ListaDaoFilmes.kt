package br.edu.fatecpg.listafilme.dao

import br.edu.fatecpg.listafilme.model.ListaF


 class ListaDaoFilmes:ListaDaoFilmesInterface {
    companion object{
        private val filmes = mutableListOf<ListaF>()
    }

    override fun adcionarFilmes(filmes: ListaF) {
        Companion.filmes.add(filmes)
    }


    override fun obterFilmes(): List<ListaF> {
        return Companion.filmes
    }

}