package com.udacity.shoestore

import android.widget.EditText
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {

    var shoe: Shoe = Shoe("", 0.0, "", "", listOf(""))
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList
    fun addToShoeList(){
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
}