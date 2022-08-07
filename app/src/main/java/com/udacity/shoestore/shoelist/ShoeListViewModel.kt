package com.udacity.shoestore.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel:ViewModel() {
    private val _shoeList = MutableLiveData<Shoe>()
    val shoeList:LiveData<Shoe>
        get() = _shoeList
    init {
        createShoeList()
    }

    private fun createShoeList() {
        TODO("Not yet implemented")
    }
}