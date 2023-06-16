package org.d3if3030.anggrek.ui.listdata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3030.anggrek.model.Orchid
import org.d3if3030.anggrek.network.ApiStatus
import org.d3if3030.anggrek.network.OrchidApi

class ListDataViewModel : ViewModel() {
    private val data = MutableLiveData<List<Orchid>>()
    private val status = MutableLiveData<ApiStatus>()
    init {
        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(OrchidApi.service.getOrchid())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("ListdataViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)

            }
        }
    }
    fun getData(): LiveData<List<Orchid>> = data
    fun getStatus(): LiveData<ApiStatus> = status
}