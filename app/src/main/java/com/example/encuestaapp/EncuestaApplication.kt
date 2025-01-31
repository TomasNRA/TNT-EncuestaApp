package com.example.encuestaapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import com.example.encuestaapp.db.AlimentoEncuestaRepository
import com.example.encuestaapp.db.AppRoomDB
import com.example.encuestaapp.db.EncuestaRepository

public class EncuestaApplication: Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppRoomDB.getDatabase(this, applicationScope) }
    val repository by lazy { AlimentoEncuestaRepository(database.alimentoDao()) }
    val encuestaRepository by lazy { EncuestaRepository(database.encuestaDao()) }
}