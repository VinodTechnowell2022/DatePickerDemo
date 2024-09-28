package com.tw.datepickerdemo

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.tw.datepickerdemo.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DatePickerScreen : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val now = Calendar.getInstance()
    private lateinit var dateListener: DatePickerDialog.OnDateSetListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeDatePickerDialog()

        binding.ivDate.setOnClickListener {
            chooseDate()
        }

    }

    private fun chooseDate() {
        val dialog = DatePickerDialog(this@DatePickerScreen,
            dateListener,
            // set DatePickerDialog to point to today's date when it loads up
            now.get(Calendar.YEAR),
            now.get(Calendar.MONTH),
            now.get(Calendar.DAY_OF_MONTH))
        dialog.datePicker.minDate= now.timeInMillis
        dialog.datePicker.maxDate= now.timeInMillis
        dialog.show()
    }

    private fun initializeDatePickerDialog() {
        // create an OnDateSetListener
        dateListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                now.set(Calendar.YEAR, year)
                now.set(Calendar.MONTH, monthOfYear)
                now.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "yyyy-MM-dd" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                sdf.format(now.getTime()).also { it -> binding.etDate.setText(it.toString()) }
            }
        }
    }

}