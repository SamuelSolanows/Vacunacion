package com.example.vacunacion1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vacunacion1.R
import com.example.vacunacion1.clases.Raza
import com.example.vacunacion1.clases.Tipo
import com.example.vacunacion1.controler.RazaController
import com.example.vacunacion1.databinding.ReciclarRazaBinding
import com.example.vacunacion1.databinding.ReciclarTipoBinding

class RazaAdapter(var raza: MutableList<Raza>) : RecyclerView.Adapter<RazaAdapter.Holder>() {
    inner class Holder(var binding: ReciclarRazaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ReciclarRazaBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.reciclar_raza, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var pasision = raza.get(position)
        pasision.apply {
            holder.binding.apply {
                textView2.text = Nombre
                imageView3.setOnClickListener {
                    RazaController(root.context).eliminar(pasision)
                    raza.remove(pasision)
                    notifyItemRemoved(position)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return raza.size
    }
}