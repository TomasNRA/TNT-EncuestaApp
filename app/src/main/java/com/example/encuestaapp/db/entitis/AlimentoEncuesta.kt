package com.example.encuestaapp.db.entitis

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "alimentosEncuesta",
    foreignKeys = [ForeignKey(entity = Encuesta::class, parentColumns = ["id"], childColumns = ["idEncuesta"])])
data class AlimentoEncuesta(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "idEncuesta")
    var idEncuesta: Int = 0,
    @ColumnInfo(name = "alimento")
    val alimento: String,
    @ColumnInfo(name = "porcion")
    val porcion: String,
    @ColumnInfo(name = "frecuencia")
    val frecuencia: String,
    @ColumnInfo(name = "cantidad")
    val cantidad: Int = 0
)