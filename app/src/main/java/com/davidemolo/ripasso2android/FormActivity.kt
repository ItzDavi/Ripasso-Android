package com.davidemolo.ripasso2android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import com.davidemolo.ripasso2android.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, resources.getStringArray(R.array.SpinnerOptions))
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.ageSpinner.adapter = spinnerAdapter

        binding.sendButton.setOnClickListener {
            checkData()
        }
    }

    private fun checkData() {
        if (binding.wordTextview.text.toString().isEmpty()) {
            Toast.makeText(this, getString(R.string.empty_edittext_message), Toast.LENGTH_SHORT).show()

        } else if (binding.ageSpinner.selectedItem == null) {
            Toast.makeText(this, getString(R.string.empty_age_spinner), Toast.LENGTH_SHORT).show()

        } else if (binding.radioGroup.checkedRadioButtonId == -1) {
            Toast.makeText(this, getString(R.string.empty_radio_button), Toast.LENGTH_SHORT).show()

        } else {
            sendData()
        }
    }

    private fun sendData() {
        val text = binding.wordTextview.text.toString()
        val age = binding.ageSpinner.selectedItem.toString()

        val button = findViewById<RadioButton>(binding.radioGroup.checkedRadioButtonId)
        val option = button.text.toString()

        val intent = Intent(this, DataActivity::class.java)
        intent.putExtra("text", text)
        intent.putExtra("age", age)
        intent.putExtra("option", option)

        startActivity(intent)
    }
}