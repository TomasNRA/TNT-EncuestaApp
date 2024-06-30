package com.example.encuestaapp.db.entitis

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "encuestas")
data class Encuesta(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "fecha")
    val fecha: String,

)