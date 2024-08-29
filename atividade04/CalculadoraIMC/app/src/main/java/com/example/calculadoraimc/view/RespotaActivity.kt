package com.example.calculadoraimc.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimc.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RespotaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_respota)

        val btn_float = findViewById<FloatingActionButton>(R.id.btn_float)

        btn_float.setOnClickListener {
            finish()
        }

    }
}