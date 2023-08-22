package com.example.compoundinterestcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.compoundinterestcalculator.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.buttonCalcular.setOnClickListener {

            try {

                val capitalInicial =
                    binding.editTextNumberDecimalCapitalInicial.text.toString().toDouble()
                val aportacionAnual =
                    binding.editTextNumberDecimalAportacionAnual.text.toString().toDouble()
                val anyos = binding.editTextNumberDecimalAnyos.text.toString().toInt()
                val interes = binding.editTextNumberDecimalIniacial.text.toString().toDouble()

                val capitalInicialDouble = capitalInicial.toDouble()
                val aportacionAnualDouble = aportacionAnual.toDouble()
                val anyosInt = anyos.toInt()
                val interesDouble = interes.toDouble()

                var total = capitalInicialDouble

                for (x in 0 until anyosInt) {

                    total += total * interes / 100 + aportacionAnualDouble;

                }



                binding.textViewResultado.text = Editable.Factory.getInstance()
                    .newEditable(total.toFloat().toString())
            } catch (e: java.lang.NumberFormatException) {
                binding.textViewResultado.text = Editable.Factory.getInstance()
                    .newEditable("No puede haber campos vacios")
            }


        }
    }
}