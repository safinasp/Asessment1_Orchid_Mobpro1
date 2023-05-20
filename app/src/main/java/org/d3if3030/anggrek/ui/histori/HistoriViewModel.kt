package org.d3if3030.anggrek.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3030.anggrek.data.OrchidDao

class HistoriViewModel(private val db: OrchidDao) : ViewModel() {
    val data = db.getLastUniverse()
    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}