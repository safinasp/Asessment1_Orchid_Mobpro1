package org.d3if3030.anggrek.listorchid

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3030.anggrek.model.Orchid
import org.d3if3030.anggrek.model.OrchidList
import org.d3if3030.anggrek.network.ApiStatus
import org.d3if3030.anggrek.network.OrchidApi
import org.d3if3030.anggrek.network.UpdateWorker
import java.util.concurrent.TimeUnit

class ListOrchidViewModel : ViewModel() {
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
                Log.d("ListOrchidViewModel", "Failure: ${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData():  LiveData<List<Orchid>> = data

    fun getStatus(): LiveData<ApiStatus> = status

    fun  scheduleUpdater(app:Application){
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1,TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            UpdateWorker.WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }
}