package com.example.vacunacion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vacunacion1.adapter.RazaAdapter
import com.example.vacunacion1.clases.Raza
import com.example.vacunacion1.controler.RazaController
import com.example.vacunacion1.databinding.ActivityRazaBinding

class RazaActivity : AppCompatActivity() {
    lateinit var binding: ActivityRazaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRazaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llenarrecycle()
        try {


            binding.apply {
                btnAgregarMascota.setOnClickListener {
                    RazaController(this@RazaActivity).insertar(
                        Raza(
                            0,
                            txtNombreMascota.text.toString()
                        )
                    )
                    txtNombreMascota.setText("")
                    llenarrecycle()
                }
            }
        }catch (e:Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun llenarrecycle() {
        binding.RecicleRa.layoutManager = LinearLayoutManager(this@RazaActivity)
        binding.RecicleRa.adapter = RazaAdapter(RazaController(this@RazaActivity).leer())

    }
}