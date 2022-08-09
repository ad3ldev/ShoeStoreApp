package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    var index: Int, val images: List<String> = mutableListOf(
        "shoe_01", "shoe_02", "shoe_03", "shoe_04",
        "shoe_05", "shoe_06", "shoe_07", "shoe_08", "shoe_09", "shoe_10", "shoe_11", "shoe_12"
    )
) : Parcelable