package com.tw.datepickerdemo

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tw.datepickerdemo.databinding.ActivityMain2Binding
import com.tw.datepickerdemo.databinding.ActivityStartDtEndDtScreenBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class StartDtEndDtScreen : AppCompatActivity() {
    
    lateinit var binding: ActivityStartDtEndDtScreenBinding
    val TAG:String = "StartDtEndDtScreen"

    val startCalendar = Calendar.getInstance()
    private lateinit var startdtListener: DatePickerDialog.OnDateSetListener

    val endCalendar = Calendar.getInstance()
    private lateinit var enddtListener: DatePickerDialog.OnDateSetListener
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartDtEndDtScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeStartDtListener()
        
        binding.ivStartDt.setOnClickListener {
            chooseDate()
        }
        
        binding.llEndDt.setOnClickListener {
            initializeEndDtListener()

        }
        
    }

    private fun initializeStartDtListener(){
        // initialize startdtListener
        startdtListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                startCalendar.set(Calendar.YEAR, year)
                startCalendar.set(Calendar.MONTH, monthOfYear)
                startCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "yyyy-MM-dd" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                sdf.format(startCalendar.getTime()).also { it -> binding.etStartDt.setText(it.toString()) }
            }
    }

    private fun initializeEndDtListener(){
        // initialize startdtListener
        enddtListener =
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                endCalendar.set(Calendar.YEAR, year)
                endCalendar.set(Calendar.MONTH, monthOfYear)
                endCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "yyyy-MM-dd" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                sdf.format(endCalendar.getTime()).also { it -> binding.etEndDt.setText(it.toString()) }
            }

        chooseEndDate()
    }

    private fun chooseDate() {
        val dialog = DatePickerDialog(this@StartDtEndDtScreen,
            startdtListener,
            // set DatePickerDialog to point to today's date when it loads up
            startCalendar.get(Calendar.YEAR),
            startCalendar.get(Calendar.MONTH),
            startCalendar.get(Calendar.DAY_OF_MONTH))
        dialog.datePicker.minDate= startCalendar.timeInMillis
        dialog.show()
    }

    private fun chooseEndDate() {
        val dialog = DatePickerDialog(this@StartDtEndDtScreen,
            enddtListener,
            // set DatePickerDialog to point to today's date when it loads up
            endCalendar.get(Calendar.YEAR),
            endCalendar.get(Calendar.MONTH),
            endCalendar.get(Calendar.DAY_OF_MONTH))
        dialog.datePicker.minDate= startCalendar.timeInMillis
        dialog.show()
    }

}