package com.example.listadetarefas.dao

import com.example.listadetarefas.model.ListaT

class ListaDaoTarefas : ListaDaoTarefasInterface {
    companion object {
        private val tarefas = mutableListOf<ListaT>()  // Lista mutável
    }

    override fun adionarTarefa(tarefa: ListaT) {
        tarefas.add(tarefa)
    }

    // Alterar o retorno para MutableList
    override fun obterLista(): MutableList<ListaT> {
        return tarefas  // Retorna a lista mutável
    }
}
