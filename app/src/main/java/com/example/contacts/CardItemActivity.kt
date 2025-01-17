package com.example.contacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.contacts.databinding.CardItemBinding

class CardItemActivity : AppCompatActivity() {

    lateinit var binding: CardItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CardItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.cardContact
    }
}