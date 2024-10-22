package com.inforcap.exampleintentsbundles

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.inforcap.exampleintentsbundles.databinding.ActivitySecondBinding
import com.inforcap.exampleintentsbundles.model.User

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = (intent.extras?.get("BUNDLE_KEY") as Bundle).getParcelable<User>("USER_KEY")

        if (user != null) {
            binding.textViewNombre.text = "Nombre Usuario: " + user.name
            binding.textViewEdad.text = "Edad Usuario: "+ user.age.toString()
        }

    }
}