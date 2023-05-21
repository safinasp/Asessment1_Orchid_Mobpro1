package org.d3if3030.anggrek.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface OrchidDao {
    @Insert
    fun insert(orchid: OrchidEntity)

    @Query("SELECT * FROM orchid ORDER BY id DESC")
    fun getLastOrchid(): LiveData<List<OrchidEntity>>

    @Query("DELETE FROM orchid")
    fun clearData()
}