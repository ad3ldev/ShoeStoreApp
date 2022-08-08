package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.lang.Exception

class ShoeViewModel : ViewModel() {

    var shoe: Shoe = Shoe("", 0.0, "", "", listOf(""))
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    fun addToShoeList() {
        val newShoe = shoe.copy()
        _shoeList.value = _shoeList.value?.plus(newShoe) ?: listOf(newShoe)
        clearShoe()
    }

    fun clearShoe() {
        shoe.name = ""
        shoe.size = 0.0
        shoe.company = ""
        shoe.description = ""
    }
    fun validate(){
        validateName()
        validateCompany()
        validateDetails()
        validateSize()
    }
    private fun validateName(): Boolean {
        if (shoe.name.isBlank()) {
            throw Exception("Name field can't be empty")
        }
        return true
    }
    private fun validateCompany(): Boolean {
        if (shoe.company.isBlank()) {
            throw Exception("Company field can't be empty")
        }
        return true
    }
    private fun validateDetails(): Boolean {
        if (shoe.description.isBlank()) {
            throw Exception("Details field can't be empty")
        }
        return true
    }
    private fun validateSize(): Boolean {
        if (shoe.size == 0.0) {
            throw Exception("Size field can't be empty")
        }
        return true
    }
}