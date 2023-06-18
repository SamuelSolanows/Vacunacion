package com.example.vacunacion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vacunacion1.adapter.VacunaAdapter
import com.example.vacunacion1.clases.Vacuna
import com.example.vacunacion1.controler.VacunaControler
import com.example.vacunacion1.databinding.ActivityVacunaBinding

class VacunaActivity : AppCompatActivity() {
    lateinit var binding: ActivityVacunaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityVacunaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            Recivacuna.layoutManager=LinearLayoutManager(this@VacunaActivity)
            Recivacuna.adapter=VacunaAdapter(VacunaControler(this@VacunaActivity).leer())
            btnAgregarMascota.setOnClickListener {
                VacunaControler(this@VacunaActivity).insertar(Vacuna(0,txtNombreMascota.text.toString()))
            }
        }
    }
}