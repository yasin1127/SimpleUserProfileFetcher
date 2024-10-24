package com.example.carapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carapplication.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val price = intent.getDoubleExtra("price",0.0)
        val img = intent.getIntExtra("image",0)
        val desc = intent.getStringExtra("desc")

        binding.apply {
            CarName.text = name
            CarP.text = "Price: $"+price.toString()
            CarImg.setImageResource(img)
            CarDesc.text = desc
        }

    }
}