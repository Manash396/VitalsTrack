package com.mk.vitaltrack.data.local

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    // two thread see the immediate change if it change by one
    @Volatile
    private var INSTANCE : VitalsDatabase? = null

    // two null check if the case two thread at the same time reach first an see INSTANCE ==  null
    fun provideDatabase(context : Context): VitalsDatabase{
        return INSTANCE ?: synchronized(this){
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                VitalsDatabase::class.java,
                VitalsDatabase.DATABASE_NAME
            ).build().also {
                INSTANCE = it
            }
        }
    }

    fun provideDao(context: Context): VitalsDao{
        return provideDatabase(context).vitalsDao()
    }
}