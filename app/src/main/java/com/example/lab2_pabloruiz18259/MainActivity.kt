package com.example.lab2_pabloruiz18259
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception
/**
 * <h1>MainActivity</h1>
 *<p>
 * Generates the app and calculates the body mass index
 *</p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-05
 **/
class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    // Button that processes data and user input
    lateinit var processButton: Button
    lateinit var height: EditText
    lateinit var weight: EditText

    /**
     * Builds the app initialization
     * @param savedInstanceState saved App data
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Gets the specified elements by id
        processButton = findViewById(R.id.processButton)
        height = findViewById(R.id.height)
        weight = findViewById(R.id.weight)

        // Button is set with on click listener and on long click listener
        processButton.setOnClickListener(this)
        processButton.setOnLongClickListener(this)
    }

    /**
     * Calculates BMI on the button press
     * @param view that contains the listener
     */
    override fun onClick(view: View?) {
        // try catch avoids empty inputs
        try {

            // Values gotten from the user input
            val heightDouble: Double = height.text.toString().toDouble() / 100.0    // To meters
            val weightDouble: Double = weight.text.toString().toDouble() * 0.453592 // To kilograms
            val calculationResult: Double = weightDouble / (heightDouble * heightDouble)    // BMI

            // Saves the intent to load the next activity
            val results = Intent(this, Result::class.java)
            results.putExtra("result", calculationResult)   // Makes the result accessible

            // If the introduced height is within range
            if(heightDouble in 0.01..2.70 && weightDouble in 1.0..1800.0) {
                startActivity(results)  // New activity is instanced
            } else {
                // Error message appears according to the incorrect input
                if(heightDouble !in 0.01..2.70) {
                    Toast.makeText(this,
                        "Ingrese un valor entre 1 y 270 en la altura", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this,
                        "Ingrese un valor entre 1 y 1800 en el peso", Toast.LENGTH_SHORT).show()
                }
            }

        // If an input statement is empty, a message appears
        } catch(e: Exception) {
            Toast.makeText(this, "Por favor no deje entradas vacias", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * Shows the BMI index on a long press
     * @param view that contains the listener
     */
    override fun onLongClick(v: View?): Boolean {
        Toast.makeText(this, "IMC = Peso (kg) / altura (m) ^ 2", Toast.LENGTH_SHORT).show()
        return true
    }
}
