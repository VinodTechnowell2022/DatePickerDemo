package com.tw.datepickerdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tw.datepickerdemo.databinding.ActivityMain2Binding
import com.tw.datepickerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSimpleDatePicker.setOnClickListener {
            val intent = Intent(this, DatePickerScreen::class.java)
            startActivity(intent)
        }

        binding.btnStartDtEndDtDatePicker.setOnClickListener {
            val intent = Intent(this, StartDtEndDtScreen::class.java)
            startActivity(intent)
        }

    }

}