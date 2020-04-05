package com.example.lab2_pabloruiz18259
import kotlin.math.round
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.awt.font.TextAttribute

class Result : AppCompatActivity() {

    lateinit var imc_display: TextView
    lateinit var interpretation: TextView
    lateinit var imc_image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val imc: Double = intent.getDoubleExtra("result", 0.0)
        imc_display = findViewById(R.id.numeric_imc_result)
        interpretation = findViewById(R.id.imc_text)
        imc_image = findViewById(R.id.imc_visualization)

        imc_display.text = (round(imc * 100) / 100).toString()

        if(imc < 18.5) {
            interpretation.text = getString(R.string.low_imc)
            imc_image.setImageResource(R.drawable.underweight)
        } else if (imc < 25) {
            interpretation.text = getString(R.string.ideal_imc)
            imc_image.setImageResource(R.drawable.ideal)
        } else if(imc < 30) {
            interpretation.text = getString(R.string.imc_overweight)
            imc_image.setImageResource(R.drawable.overweight)
        } else {
            interpretation.text = getString(R.string.imc_obese)
            imc_image.setImageResource(R.drawable.obesity)
        }
    }
}
