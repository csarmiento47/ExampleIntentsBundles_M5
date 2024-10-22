package com.inforcap.exampleintentsbundles

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.inforcap.exampleintentsbundles.databinding.ActivityMainBinding
import com.inforcap.exampleintentsbundles.model.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user: User = User(5,"Samuel",42)

        val bundle = Bundle().apply {
            putParcelable("USER_KEY",user)
            putString("lala","Lala")
        }

        binding.buttonIntent.setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java).apply {
                putExtra("BUNDLE_KEY",bundle)
            })
        }

        val gmmIntentUri = Uri.parse("geo:51.17885270841654,-1.8261525945670793")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        mapIntent.resolveActivity(packageManager)?.let {
        }

        binding.buttonIntentMaps.setOnClickListener {
            startActivity(mapIntent)
        }


        val gmmIntentUri2 = Uri.parse("google.streetview:cbll=51.17885270841654,-1.8261525945670793")
        val mapIntent2 = Intent(Intent.ACTION_VIEW, gmmIntentUri2)
        mapIntent.setPackage("com.google.android.apps.maps")
        mapIntent.resolveActivity(packageManager)?.let {

        }
        binding.buttonIntentMapsTwo.setOnClickListener {
            startActivity(mapIntent2)
        }




    }
}