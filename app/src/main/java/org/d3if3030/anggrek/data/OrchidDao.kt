package org.d3if3030.anggrek.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface OrchidDao {
    @Insert
    fun insert(unniversethings: OrchidEntity)

    @Query("SELECT * FROM universethings ORDER BY id DESC")
    fun getLastUniverse(): LiveData<List<OrchidEntity>>

    @Query("DELETE FROM universethings")
    fun clearData()
}