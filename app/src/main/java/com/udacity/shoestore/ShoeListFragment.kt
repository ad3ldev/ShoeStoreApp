package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeViewBinding

class ShoeListFragment: Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel:ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        val list = viewModel.shoeList.value
            if (list != null) {
                for (element in list){
                    val newShoe:ShoeViewBinding = DataBindingUtil.inflate(inflater,R.layout.shoe_view,container, false)
                    newShoe.shoeName.text = element.name
                    newShoe.shoeSize.text =element.size.toString()
                    newShoe.shoeCompany.text=element.company
                    newShoe.shoeImage.setImageResource(R.drawable.ic_launcher_background)
                    binding.linearLayout.addView(newShoe.root)
                }
            }
        binding.addShoeButton.setOnClickListener{view:View->
            view.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }
        return binding.root
    }
}