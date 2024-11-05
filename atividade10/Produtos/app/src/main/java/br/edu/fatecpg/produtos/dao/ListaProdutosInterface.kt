package br.edu.fatecpg.produtos.dao

import br.edu.fatecpg.produtos.model.ListaP

interface ListaProdutosInterface {
    fun obterProdutos(): MutableList<ListaP>
    fun adcinoarProduto(Produto:ListaP)
}