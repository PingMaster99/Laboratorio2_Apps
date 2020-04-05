package com.example.lab2_pabloruiz18259

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Result : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val imc: Double = intent.getDoubleExtra("result", 0.0)

        if(imc < 18.5) {

        } else if (imc < 30) {

        } else {

        }
    }
}
