package com.example.app01.viewmodel

import android.app.admin.TargetUser
import androidx.lifecycle.ViewModel
import com.example.app01.model.Usuario

class LoginViewModel:ViewModel() {
    private val usuarios = mutableListOf<Usuario>()

    fun logar(user: Usuario):String {
        val retorno = usuarios.find { user.login == it.login  && user.senha == it.senha }
        if(retorno!=null) {
              return "Login Realizado com Sucesso"
        }else {
               return "Login Inválido!"
        }

    }

    fun cadastrar(user:Usuario):String {
        val retorno = usuarios.find {user.login == it.login && user.senha == it.senha}
        if(retorno == null )  {
            usuarios.add(user)
            return "Cadastrado Com sucesso"
        }else { return  "Usuario já Cadastrado "}


    }
}