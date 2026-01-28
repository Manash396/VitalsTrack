package com.mk.vitaltrack.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVitals(entity: VitalEntity)

    @Query("SELECT * FROM vitals ORDER BY recordedAt DESC")
    fun observeVitals(): Flow<List<VitalEntity>>

}