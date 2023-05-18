package org.d3if3030.anggrek.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orchid")
data class OrchidEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var namaAnggrek: String
)