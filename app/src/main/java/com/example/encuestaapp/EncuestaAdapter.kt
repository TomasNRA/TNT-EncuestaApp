package com.example.encuestaapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.encuestaapp.db.entitis.Encuesta

class EncuestaAdapter():RecyclerView.Adapter<EncuestaViewHolder>() {

    private var elementos: List<Encuesta> = listOf()

    fun actualizarDatos(nuevosElementos: List<Encuesta>) {
        elementos = nuevosElementos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EncuestaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EncuestaViewHolder(layoutInflater.inflate(R.layout.item_encuesta_list,parent, false))
    }

    override fun getItemCount(): Int = elementos.size

    override fun onBindViewHolder(holder: EncuestaViewHolder, position: Int) {
        val item = elementos[position]
        holder.render(item)
    }
}