package com.ibrajix.c2c.ui.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrajix.c2c.data.model.ExhibitResponse
import com.ibrajix.c2c.data.repo.MainRepo
import com.ibrajix.c2c.network.Resource
import com.ibrajix.c2c.utils.GeneralUtility
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepo: MainRepo) : ViewModel() {

    private val _data = MutableStateFlow<ExhibitResponse?>(null)
    val data = _data.asStateFlow()

    private val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()

    private val _errorMessage = MutableSharedFlow<String>()
    val errorMessage = _errorMessage.asSharedFlow()

    fun getData(){

        viewModelScope.launch {

            _loading.emit(true)

                val response = mainRepo.getData()
                when(response.status){
                    Resource.Status.SUCCESS -> {
                        _data.emit(response.data)
                        _loading.emit(false)
                    }
                    Resource.Status.ERROR -> {
                        _errorMessage.emit("Something went wrong")
                        _loading.emit(false)
                    }
                    Resource.Status.FAILURE -> {
                        _errorMessage.emit("Something went wrong")
                        _loading.emit(false)
                    }
                }
        }
    }
}