package com.example.calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnOhm = findViewById<Button>(R.id.btn_OHM)

        btnOhm.setOnClickListener {
            val intent = Intent(this, OHM_Activity::class.java)
            startActivity(intent)
        }

        val btnOperacoe = findViewById<Button>(R.id.btn_Operacoes)

        btnOperacoe.setOnClickListener {
            val intent = Intent(this, Operacoe_Activity::class.java)
            startActivity(intent)
        }
    }
}