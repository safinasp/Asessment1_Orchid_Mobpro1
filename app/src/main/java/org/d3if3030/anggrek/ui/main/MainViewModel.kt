package org.d3if3030.anggrek.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3030.anggrek.data.OrchidDao
import org.d3if3030.anggrek.data.OrchidEntity
import org.d3if3030.anggrek.model.HasilAnggrek
import org.d3if3030.anggrek.model.cariAnggrek

class MainViewModel (private val db: OrchidDao) : ViewModel() {
    private val hasilAnggrek = MutableLiveData<HasilAnggrek?>()

    fun cariAnggrek(anggrek:String) {
        val dataAnggrek = OrchidEntity(
            namaAnggrek = anggrek
        )
        hasilAnggrek.value = dataAnggrek.cariAnggrek()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataAnggrek)
            }
        }
    }
    fun getHasilOrchid(): LiveData<HasilAnggrek?> = hasilAnggrek
}