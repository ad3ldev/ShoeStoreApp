package com.udacity.shoestore

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {

    var shoe: Shoe = Shoe("", 0.0, "", "", 0)

    private val _shoeIndex = MutableLiveData<Int>()
    val shoeIndex:LiveData<Int>
        get() = _shoeIndex

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        _shoeIndex.value = 0
    }

    fun addToShoeList() {
        shoe.index = getImage()
        val newShoe = shoe.copy()
        _shoeList.value = _shoeList.value?.plus(newShoe) ?: listOf(newShoe)
        clearShoe()
    }

    fun clearShoe() {
        shoe.name = ""
        shoe.size = 0.0
        shoe.company = ""
        shoe.description = ""
        shoe.index = 0
    }

    fun validate() {
        validateName()
        validateCompany()
        validateDetails()
        validateSize()
    }

    fun changePicture() {
        if (shoeIndex.value!! < shoe.images.size-1) {
            _shoeIndex.value = _shoeIndex.value?.plus(1)
        } else {
            _shoeIndex.value = 0
        }
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

    fun getImage():Int {
        return when (shoe.images[shoeIndex.value!!]) {
            "shoe_01" -> (R.drawable.shoe_01)
            "shoe_02" -> (R.drawable.shoe_02)
            "shoe_03" -> (R.drawable.shoe_04)
            "shoe_04" -> (R.drawable.shoe_05)
            "shoe_05" -> (R.drawable.shoe_06)
            "shoe_06" -> (R.drawable.shoe_07)
            "shoe_07" -> (R.drawable.shoe_08)
            "shoe_08" -> (R.drawable.shoe_08)
            "shoe_09" -> (R.drawable.shoe_09)
            "shoe_10" -> (R.drawable.shoe_10)
            else -> (R.drawable.shoe_11)
        }
    }
}