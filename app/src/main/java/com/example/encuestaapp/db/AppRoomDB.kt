package com.example.encuestaapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.encuestaapp.db.daos.AlimentoEncuestaDao
import com.example.encuestaapp.db.daos.EncuestaDao
import com.example.encuestaapp.db.entitis.AlimentoEncuesta
import com.example.encuestaapp.db.entitis.Encuesta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [AlimentoEncuesta::class, Encuesta::class], version = 1)
abstract class AppRoomDB:RoomDatabase() {
    abstract fun alimentoDao():AlimentoEncuestaDao
    abstract fun encuestaDao(): EncuestaDao

    private class AppDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var alimentoDao = database.alimentoDao()
                    var encuestaDao = database.encuestaDao()

                    // Delete all content here.
                    alimentoDao.deleteAll()
                    encuestaDao.deleteAll()

                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppRoomDB? = null

        fun getDatabase(context: Context,scope: CoroutineScope): AppRoomDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDB::class.java,
                    "app_database"
                ).addCallback(AppDatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}