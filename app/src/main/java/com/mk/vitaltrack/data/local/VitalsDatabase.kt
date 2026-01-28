package com.mk.vitaltrack.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [VitalEntity::class],
    version = 1,
    exportSchema = true
)
 abstract class VitalsDatabase : RoomDatabase() {

    abstract fun vitalsDao() : VitalsDao

    companion object {
        const val DATABASE_NAME = "vitals_db"
    }
}