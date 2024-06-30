package com.example.encuestaapp.db

import androidx.annotation.WorkerThread
import com.example.encuestaapp.db.daos.EncuestaDao
import com.example.encuestaapp.db.entitis.Encuesta
import kotlinx.coroutines.flow.Flow

class EncuestaRepository(private val encuestaDao: EncuestaDao) {
    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allEncuestas: Flow<List<Encuesta>> = encuestaDao.getEncuestas()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(encuesta: Encuesta): Long {
        return encuestaDao.insert(encuesta)
    }
}