package com.example.vacunacion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
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
            llenarRecycle()
            btnAgregarMascota.setOnClickListener {
                if(txtNombreMascota.text.isEmpty()){
                    txtNombreMascota.setError("campo necesario")
                }else{
                    VacunaControler(this@VacunaActivity).insertar(Vacuna(0,txtNombreMascota.text.toString()))
                    Toast.makeText(this@VacunaActivity, "Guardado", Toast.LENGTH_SHORT).show()
                    llenarRecycle()
                    txtNombreMascota.setText("")
                }

            }
        }
    }

    fun llenarRecycle(){
        binding.Recivacuna.layoutManager=LinearLayoutManager(this@VacunaActivity)
        binding.Recivacuna.adapter=VacunaAdapter(VacunaControler(this@VacunaActivity).leer())
    }

}