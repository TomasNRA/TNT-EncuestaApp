package com.example.encuestaapp.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.encuestaapp.db.entitis.AlimentoEncuesta
import com.example.encuestaapp.db.entitis.Encuesta
import kotlinx.coroutines.flow.Flow

@Dao
interface EncuestaDao {
    @Query("SELECT * FROM encuestas")
    fun getEncuestas(): Flow<List<Encuesta>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(encuesta: Encuesta):Long

    @Query("DELETE FROM encuestas")
    suspend fun deleteAll()
}