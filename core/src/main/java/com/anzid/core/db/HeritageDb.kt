package com.anzid.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PersonEntity::class], version = HeritageDb.HERITAGE_DB_VERSION, exportSchema = false)
abstract class HeritageDb : RoomDatabase() {

    abstract fun personDao(): PersonDao

    companion object {
        const val HERITAGE_DB_VERSION = 1
        private const val HERITAGE_DB_NAME = "heritage_db"

        private lateinit var instance: HeritageDb

        fun getDatabase(context: Context): HeritageDb {
            if (Companion::instance.isInitialized.not()) {
                instance = Room.databaseBuilder(context.applicationContext, HeritageDb::class.java, HERITAGE_DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance
        }
    }
}