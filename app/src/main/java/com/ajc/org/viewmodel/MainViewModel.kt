package com.ajc.org.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajc.org.model.local.NewsEntity
import com.ajc.org.model.remote.ResponseDTO
import com.ajc.org.repository.DataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun createTransaction() {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepository.getData()
        }
    }

    val user: LiveData<ResponseDTO> get() = dataRepository.user

    fun insertDataInDb(itunesDbTable: NewsEntity) {
        dataRepository.insertDataInDb(itunesDbTable)
    }

    fun deleteDataFromDb() {
        dataRepository.deleteDataFromDb()
    }

    fun getDataFromDb() {
        dataRepository.getDataFromDb()
    }

    fun getData(): LiveData<List<NewsEntity>> {
        return dataRepository.getDataFromDb()
    }
}
