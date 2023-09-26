package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val spinnerTicketType = findViewById<Spinner>(R.id.spinnerTicketType)
        val buttonPesan = findViewById<Button>(R.id.buttonPesan)

        // Menambahkan opsi tiket ke dalam Spinner
        val ticketTypes = arrayOf("Bisnis", "Ekonomi", "Dll") // Ganti dengan daftar jenis tiket yang Anda inginkan
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ticketTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTicketType.adapter = adapter

        buttonPesan.setOnClickListener {
            val selectedTime = "${timePicker.hour}:${timePicker.minute}"
            val selectedDate = "${datePicker.dayOfMonth}/${datePicker.month + 1}/${datePicker.year}"
            val selectedTicketType = spinnerTicketType.selectedItem.toString()

            val toastMessage = "Anda telah memesan tiket pada tanggal $selectedDate, jam $selectedTime, dengan jenis tiket $selectedTicketType."
            Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show()
        }
    }
}
