package com.example.calculadoraimcapplication.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimcapplication.R
import com.example.calculadoraimcapplication.dao.UsuarioDao
import com.example.calculadoraimcapplication.model.Usuario

class CalcularIMCActivity : AppCompatActivity() {
    val usuario = UsuarioDao();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calcular_imcactivity)

        val edit_peso = findViewById<EditText>(R.id.edit_peso);
        val edit_altura = findViewById<EditText>(R.id.edit_altura);
        val btn = findViewById<Button>(R.id.btn);



        btn.setOnClickListener {

            val altura = edit_altura.text.toString().toDouble();
            val peso = edit_peso.text.toString().toDouble();

            val usu = Usuario(altura,peso);

            usuario.cadastroUsuario(usu)




            val intent = Intent(this, RespotarActivity::class.java);
            startActivity(intent);

        }
    }
}