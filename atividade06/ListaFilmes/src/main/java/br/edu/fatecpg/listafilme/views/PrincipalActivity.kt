package br.edu.fatecpg.listafilme.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.listafilme.R
import br.edu.fatecpg.listafilme.dao.ListaDaoFilmes
import br.edu.fatecpg.listafilme.model.ListaF
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PrincipalActivity : AppCompatActivity() {
    val dao = ListaDaoFilmes();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_principal)

        val edtDiretor = findViewById<EditText>(R.id.diretortxt)
        val edtFilme = findViewById<EditText>(R.id.filmetxt)
        val btn = findViewById<Button>(R.id.btnConfirmar)
        val btnfloat = findViewById<FloatingActionButton>(R.id.btn_float)

        btn.setOnClickListener {
            val diretor = edtDiretor.text.toString()
            val filme = edtFilme.text.toString()

            val listf = ListaF(filme,diretor)



            dao.adcionarFilmes(listf);

            Toast.makeText(this,"Filme e Diretor Cadastrado",Toast.LENGTH_SHORT).show();
            edtFilme.text.clear();
            edtDiretor.text.clear();
        }

        btnfloat.setOnClickListener {
            val intent = Intent(this,SegundaActivity::class.java);
            startActivity(intent)
        }

    }
}