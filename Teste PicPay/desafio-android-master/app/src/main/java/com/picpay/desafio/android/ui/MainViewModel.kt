package com.picpay.desafio.android.ui

import androidx.lifecycle.ViewModel
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.api.PicRepository
import com.picpay.desafio.android.api.User
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val repository: PicRepository): ViewModel() {

    private val _response = MutableLiveData<List<User>>()
    val response: LiveData<List<User>> = _response

    init {
        getUsers()
    }

    private fun getUsers() = viewModelScope.launch {
        repository.getUsers()?.let {
            if (it.isSuccessful) {
                it.body()?.let { users ->
                    _response.value = users
                }
            } else {
                _response.value = null
            }
        }
    }
}