package com.example.encuestaapp.db

import androidx.annotation.WorkerThread
import com.example.encuestaapp.db.daos.AlimentoEncuestaDao
import com.example.encuestaapp.db.entitis.AlimentoEncuesta
import kotlinx.coroutines.flow.Flow

class AlimentoEncuestaRepository(private val alimentoDao: AlimentoEncuestaDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allAlimentos: Flow<List<AlimentoEncuesta>> = alimentoDao.getAlimentosEncuesta()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(alimento: AlimentoEncuesta) {
        alimentoDao.insert(alimento)
    }
}
