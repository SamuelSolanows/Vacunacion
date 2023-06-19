package com.example.vacunacion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TimePicker
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vacunacion1.adapter.TipoAdapter
import com.example.vacunacion1.clases.Tipo
import com.example.vacunacion1.controler.TipoController
import com.example.vacunacion1.databinding.ActivityTipoBinding

class TipoActivity : AppCompatActivity() {
    lateinit var binding:ActivityTipoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTipoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llenarRecycle()
        binding.apply {
            btnAgregarMascota.setOnClickListener {
                if (txtNombreMascota.text.isEmpty()){
                    txtNombreMascota.setError("campo necesario")
                }else{
                    TipoController(this@TipoActivity).insertar(Tipo(0,txtNombreMascota.text.toString()))
                    txtNombreMascota.setText("")
                    Toast.makeText(this@TipoActivity, "Guardado", Toast.LENGTH_SHORT).show()
                    llenarRecycle()
                }
            }

        }
    }

    fun llenarRecycle(){
        binding.RecycleTipo.layoutManager= GridLayoutManager(this@TipoActivity,2)
        binding.RecycleTipo.adapter=TipoAdapter(TipoController(this@TipoActivity).leer())
    }
}