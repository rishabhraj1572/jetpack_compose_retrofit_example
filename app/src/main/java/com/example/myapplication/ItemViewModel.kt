package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.myapplication.data.model.Item
import com.example.myapplication.data.remote.RetrofitClient

class ItemViewModel : ViewModel() {
    private val _items = mutableStateOf<List<Item>>(emptyList())
    val items: State<List<Item>> = _items

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.apiService.getItems()
                _items.value = response.data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
