package com.example.encuestaapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.encuestaapp.db.entitis.Encuesta

class EncuestaViewHolder(view: View): RecyclerView.ViewHolder(view)  {
    val numero = view.findViewById<TextView>(R.id.tvNumeroEncuesta)
    val fecha = view.findViewById<TextView>(R.id.tvFechaEncuesta)

    fun render(encuesta: Encuesta){
        numero.text = encuesta.id.toString()
        fecha.text = encuesta.fecha
    }
}