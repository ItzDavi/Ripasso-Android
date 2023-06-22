package com.davidemolo.ripasso2android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.davidemolo.ripasso2android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.storiesRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.storiesRecyclerview.adapter = StoryAdapter(
            listOf(
                StoryViewModel("Davide", "https://placehold.co/100x100"),
                StoryViewModel("Frighi", "https://placehold.co/100x100"),
                StoryViewModel("Raccomandato", "https://placehold.co/100x100"),
                StoryViewModel("Borsa", "https://placehold.co/100x100"),
            )
        )
    }
}