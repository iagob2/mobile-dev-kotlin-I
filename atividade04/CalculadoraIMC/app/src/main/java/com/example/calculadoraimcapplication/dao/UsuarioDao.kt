package com.example.calculadoraimcapplication.dao

import com.example.calculadoraimcapplication.model.Usuario

class UsuarioDao {
    companion object{
        private  var usuario: Usuario? = null

    }

    fun cadastroUsuario(usuario: Usuario) {
        Companion.usuario = usuario
    }

    fun exibirUsuario():Usuario {
        return  Companion.usuario?:Usuario()
    }

}