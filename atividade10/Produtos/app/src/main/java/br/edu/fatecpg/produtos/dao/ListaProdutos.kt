package br.edu.fatecpg.produtos.dao

import br.edu.fatecpg.produtos.model.ListaP

class ListaProdutos:ListaProdutosInterface {

    companion object {
        private val produtos = mutableListOf<ListaP>()
    }

    override fun obterProdutos(): MutableList<ListaP> {
        return  Companion.produtos

    }

    override fun adcinoarProduto(Produto: ListaP) {
         Companion.produtos.add(Produto)
    }
}