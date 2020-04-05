package com.example.lab2_pabloruiz18259
import kotlin.math.round
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
/**
 * <h1>Result</h1>
 *<p>
 * Shows the result of the BMI calculation
 *</p>
 *
 * @author Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-05
 **/
class Result : AppCompatActivity() {

    // Needed elements to display the result
    lateinit var imc_display: TextView
    lateinit var interpretation: TextView
    lateinit var imc_image: ImageView

    /**
     * Builds the activity when instanced
     * @param savedInstanceState saved App data
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Gets the result of the BMI from the MainActivity activity
        val imc: Double = intent.getDoubleExtra("result", 0.0)

        // Needed elments are found by id
        imc_display = findViewById(R.id.numeric_imc_result)
        interpretation = findViewById(R.id.imc_text)
        imc_image = findViewById(R.id.imc_visualization)

        // Sets the BMI visible on screen
        imc_display.text = (round(imc * 100) / 100).toString()

        // Displays the BMI result interpretation according to different ranges
        if(imc < 18.5) {
            // Underweight
            interpretation.text = getString(R.string.low_imc)   // Text
            imc_image.setImageResource(R.drawable.underweight)  // Image

        } else if (imc < 25) {
            // Ideal weight
            interpretation.text = getString(R.string.ideal_imc)
            imc_image.setImageResource(R.drawable.ideal)

        } else if(imc < 30) {
            // Overweight
            interpretation.text = getString(R.string.imc_overweight)
            imc_image.setImageResource(R.drawable.overweight)

        } else {
            // Obese
            interpretation.text = getString(R.string.imc_obese)
            imc_image.setImageResource(R.drawable.obesity)
        }
    }
}
