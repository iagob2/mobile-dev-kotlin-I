package br.edu.fatecpg

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.databinding.ActivityTerceiraBinding
import com.google.firebase.auth.FirebaseAuth

class TerceiraActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTerceiraBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTerceiraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance() // Use getInstance() para inicializar

        val email = intent.getStringExtra("email")







    }
}