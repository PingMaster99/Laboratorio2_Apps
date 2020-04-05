package com.example.lab2_pabloruiz18259
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    lateinit var processButton: Button
    lateinit var height: EditText
    lateinit var weight: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        processButton = findViewById(R.id.processButton)
        height = findViewById(R.id.height)
        weight = findViewById(R.id.weight)

        processButton.setOnClickListener(this)
        processButton.setOnLongClickListener(this)

    }

    override fun onClick(view: View?) {
        try {

            var heightDouble: Double = height.text.toString().toDouble() / 100.0
            var weightDouble: Double = weight.text.toString().toDouble() * 0.453592
            var calculationResult: Double = weightDouble / (heightDouble * heightDouble)

            val results = Intent(this, Result::class.java)
            results.putExtra("result", calculationResult)
            startActivity(results)

        } catch(e: Exception) {
            Toast.makeText(this, "Por favor no deje entradas vacias", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onLongClick(v: View?): Boolean {
        Toast.makeText(this, "IMC = Peso (kg) / altura (m) ^ 2", Toast.LENGTH_SHORT).show()
        return true
    }
}
