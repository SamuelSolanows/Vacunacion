package com.example.vacunacion1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vacunacion1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnTipo.setOnClickListener {
                startActivity(Intent(this@MainActivity,TipoActivity::class.java))
            }
            btnMascota.setOnClickListener {
                startActivity(Intent(this@MainActivity,MascotaActivity::class.java))
            }
            btnRaza.setOnClickListener {
                startActivity(Intent(this@MainActivity,RazaActivity::class.java))
            }
            btnVacunas.setOnClickListener {
                startActivity(Intent(this@MainActivity,VacunaActivity::class.java))
            }
        }
    }
}