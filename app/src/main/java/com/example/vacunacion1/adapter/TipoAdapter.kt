package com.example.vacunacion1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vacunacion1.R
import com.example.vacunacion1.clases.Tipo
import com.example.vacunacion1.controler.TipoController
import com.example.vacunacion1.databinding.ReciclarTipoBinding

class TipoAdapter(var tipo:MutableList<Tipo>):RecyclerView.Adapter<TipoAdapter.Holder>() {
    inner class Holder(var binding:ReciclarTipoBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(ReciclarTipoBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.reciclar_tipo,parent,false)))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        var pisicion=tipo.get(position)
        pisicion.apply {
            holder.binding.apply {
                txtTipoRe.text=Nombre
                btnEliminarTipo.setOnClickListener {
                    TipoController(root.context).eliminar(pisicion)
                    tipo.remove(pisicion)
                    notifyItemRemoved(position)
                }

            }
        }

    }

    override fun getItemCount(): Int {
        return tipo.size
    }
}