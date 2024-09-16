package com.example.listadetarefas.dao

import com.example.listadetarefas.model.ListaT

class ListaDaoTarefas:ListaDaoTarefasInterface {
    companion object {
        private val tarefas  = mutableListOf<ListaT>();
    }

    override fun adionarTarefa(tarefa: ListaT) {
        Companion.tarefas.add(tarefa);
    }

    override  fun obterLista():List<ListaT>{
        return Companion.tarefas
    }

}