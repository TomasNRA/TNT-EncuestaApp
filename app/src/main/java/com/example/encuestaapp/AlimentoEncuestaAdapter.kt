package com.example.encuestaapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.encuestaapp.db.entitis.AlimentoEncuesta

class AlimentoEncuestaAdapter(var elementos:List<AlimentoEncuesta?>): RecyclerView.Adapter<AlimentoEncuestaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlimentoEncuestaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AlimentoEncuestaViewHolder(layoutInflater.inflate(R.layout.item_alimento_encuesta_list,parent,false))
    }

    override fun getItemCount(): Int = elementos.size

    override fun onBindViewHolder(holder: AlimentoEncuestaViewHolder, position: Int) {
        val item = elementos[position]
        holder.render(item!!)
    }
}