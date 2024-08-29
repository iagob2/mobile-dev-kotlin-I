package com.example.calculadoraimc.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimc.R

class CalculadoraIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_calculadora_imcactivity)

        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {
            val intent = Intent(this,RespotaActivity::class.java)
            startActivity(intent)

        }

    }
}