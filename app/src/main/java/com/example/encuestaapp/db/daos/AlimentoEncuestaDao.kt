package com.example.encuestaapp.db.daos
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.example.encuestaapp.db.entitis.AlimentoEncuesta

@Dao
interface AlimentoEncuestaDao {
    @Query("SELECT * FROM alimentosEncuesta")
    fun getAlimentosEncuesta(): Flow<List<AlimentoEncuesta>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(alimento: AlimentoEncuesta)

    @Query("DELETE FROM alimentosEncuesta")
    suspend fun deleteAll()
}
