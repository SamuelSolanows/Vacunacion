package com.example.vacunacion1

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vacunacion1.adapter.MascotaAdapter
import com.example.vacunacion1.clases.Mascota
import com.example.vacunacion1.clases.Raza
import com.example.vacunacion1.clases.Tipo
import com.example.vacunacion1.controler.MascotaController
import com.example.vacunacion1.controler.RazaController
import com.example.vacunacion1.controler.TipoController
import com.example.vacunacion1.databinding.ActivityMascotaBinding

class MascotaActivity : AppCompatActivity() {
    lateinit var binding: ActivityMascotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            txtFecha.setOnClickListener {
                DatePickerDialog(this@MascotaActivity, { _, año, mes, dia ->
                    binding.txtFecha.setText("$dia/$mes/$año")
                }, 2023, 6, 19).show()
            }
            spinnerRaza.adapter = ArrayAdapter<Raza>(
                this@MascotaActivity,
                android.R.layout.simple_spinner_dropdown_item,
                RazaController(this@MascotaActivity).leer()
            )
            spinnerTipo.adapter = ArrayAdapter<Tipo>(
                this@MascotaActivity,
                android.R.layout.simple_spinner_dropdown_item,
                TipoController(this@MascotaActivity).leer()
            )
            btnAgregarMascota.setOnClickListener {
                if (txtFecha.text.isEmpty() || txtNombreMascota.text.isEmpty()) {

                } else {
                    MascotaController(this@MascotaActivity).insertar(
                        Mascota(
                            0,
                            txtNombreMascota.text.toString(),
                            1,
                            1,
                            txtFecha.text.toString()
                        )
                    )
                    llenarreci()
                }
            }

            llenarreci()

        }

    }

    fun llenarreci() {
        binding.Recicle.layoutManager = LinearLayoutManager(this@MascotaActivity)
        binding.Recicle.adapter = MascotaAdapter(MascotaController(this@MascotaActivity).leer())

    }
}