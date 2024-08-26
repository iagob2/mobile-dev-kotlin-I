package br.edu.fatecpg.trasicaoactivities.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.trasicaoactivities.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bnt = findViewById<FloatingActionButton>(R.id.float_btn)
        val bnt7 = findViewById<FloatingActionButton>(R.id.float_btn7)


        bnt.setOnClickListener {
            val intent = Intent(this,Segunda_Activity::class.java)
            intent.putExtra("Dado","Ale limea")
            startActivity(intent)
        }

        bnt7.setOnClickListener {
            val intent = Intent(this, Quarto_Activity::class.java)
            startActivity(intent)
        }



    }


}