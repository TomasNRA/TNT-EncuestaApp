package com.example.encuestaapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.encuestaapp.db.entitis.AlimentoEncuesta

class AlimentoEncuestaViewHolder(view: View): RecyclerView.ViewHolder(view)  {
    val alimento = view.findViewById<TextView>(R.id.tvAlimento)
    val porcion = view.findViewById<TextView>(R.id.tvPorcion)
    val cantidad = view.findViewById<TextView>(R.id.tvCantidad)
    val frecuencia = view.findViewById<TextView>(R.id.tvFrecuencia)

    fun render(alimentoEncuesta: AlimentoEncuesta){
        alimento.text = alimentoEncuesta.alimento
        porcion.text = alimentoEncuesta.porcion
        cantidad.text = alimentoEncuesta.cantidad.toString()
        frecuencia.text = alimentoEncuesta.frecuencia
    }
}