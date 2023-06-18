package com.example.vacunacion1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vacunacion1.R
import com.example.vacunacion1.clases.Vacuna
import com.example.vacunacion1.databinding.RecicalrVacunaBinding

class VacunaAdapter(var vacuna:MutableList<Vacuna>):RecyclerView.Adapter<VacunaAdapter.Holder>() {
    inner class Holder(var binding: RecicalrVacunaBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(RecicalrVacunaBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.recicalr_vacuna,parent,false)))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var posi=vacuna.get(position)
        posi.apply {
            holder.binding.apply {
                textView4.text=Nombre
            }
        }
    }

    override fun getItemCount(): Int {
        return vacuna.size
    }
}