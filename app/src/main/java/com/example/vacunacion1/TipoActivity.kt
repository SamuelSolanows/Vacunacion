package com.example.vacunacion1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TimePicker
import android.widget.Toast
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


        binding.apply {
            btnAgregarMascota.setOnClickListener {
                if (txtNombreMascota.text.isEmpty()){

                }else{
                    TipoController(this@TipoActivity).insertar(Tipo(0,txtNombreMascota.text.toString()))
                    txtNombreMascota.setText("")
                    Toast.makeText(this@TipoActivity, "Guardado", Toast.LENGTH_SHORT).show()
                }
            }
            RecycleTipo.layoutManager=LinearLayoutManager(this@TipoActivity)
            RecycleTipo.adapter=TipoAdapter(TipoController(this@TipoActivity).leer())
        }
    }
}