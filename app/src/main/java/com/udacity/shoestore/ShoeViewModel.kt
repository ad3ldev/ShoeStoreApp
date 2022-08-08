package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {

    var shoe: Shoe = Shoe("", 0.0, "", "", listOf(""))

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList
    init {
        addToShoeList()
    }
    private fun addToShoeList() {
        _shoeList.value = _shoeList.value?.plus(shoe) ?: listOf(shoe)
        Timber.i(shoeList.value.toString())
    }
}