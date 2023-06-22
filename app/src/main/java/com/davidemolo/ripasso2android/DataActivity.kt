package com.davidemolo.ripasso2android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davidemolo.ripasso2android.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
    }

    private fun getData() {
        if (intent.getStringExtra("text") != null) {
            binding.textTextview.text = intent.getStringExtra("text")
        }

        if (intent.getStringExtra("age") != null) {
            binding.ageTextview.text = intent.getStringExtra("age")
        }

        if (intent.getStringExtra("option") != null) {
            binding.optionTextview.text = intent.getStringExtra("option")
        }
    }
}