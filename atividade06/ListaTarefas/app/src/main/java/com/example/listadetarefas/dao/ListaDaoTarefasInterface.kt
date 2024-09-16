package com.example.listadetarefas.dao

import com.example.listadetarefas.model.ListaT

interface ListaDaoTarefasInterface {

    fun adionarTarefa(tarefa: ListaT)
    fun obterLista(): List<ListaT>
}