package com.example.vacunacion1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vacunacion1.R
import com.example.vacunacion1.clases.Mascota
import com.example.vacunacion1.databinding.ReciclarMascotaBinding

class MascotaAdapter(var mascota: MutableList<Mascota>) :
    RecyclerView.Adapter<MascotaAdapter.Holder>() {
    inner class Holder(var binding: ReciclarMascotaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ReciclarMascotaBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.activity_mascota, parent, false)
            )
        )
    }

    override fun getItemCount(): Int {
        return mascota.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var posi=mascota.get(position)
        posi.apply {
            holder.binding.apply {

            }
        }
    }
}