package org.d3if3030.anggrek.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [OrchidEntity::class], version = 1, exportSchema = false)
abstract class OrchidDb : RoomDatabase() {
    abstract val dao: OrchidDao
    companion object {
        @Volatile
        private var INSTANCE: OrchidDb? = null
        fun getInstance(context: Context): OrchidDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        OrchidDb::class.java,
                        "OrchidDb.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}