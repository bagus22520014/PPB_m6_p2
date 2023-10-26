package com.example.ppb_m6_p2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Toast
import android.widget.ToggleButton
import android.widget.Switch
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.TextView // Impor TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggle: ToggleButton = findViewById(R.id.toggleButton)
        toggle.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(applicationContext, "Hidup", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Mati", Toast.LENGTH_SHORT).show()
            }
        }

        val switchGelap: Switch = findViewById(R.id.switch_gelap)
        val layar: LinearLayout = findViewById(R.id.layar)
        switchGelap.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                layar.setBackgroundColor(0xff808080.toInt())
            } else {
                layar.setBackgroundColor(0xffffffff.toInt())
            }
        }

        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(R.layout.simple_spinner_drop_down)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
        val selectedText = "Pilihan ke $pos : ${parent.getItemAtPosition(pos)}"
        Toast.makeText(
            applicationContext,
            selectedText,
            Toast.LENGTH_SHORT
        ).show()

        // Setel teks ke TextView di atas
        val tvPesan: TextView = findViewById(R.id.tvPesan)
        tvPesan.text = selectedText
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}
