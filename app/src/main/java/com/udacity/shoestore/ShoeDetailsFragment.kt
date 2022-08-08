package com.udacity.shoestore

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {
    lateinit var binding: FragmentShoeDetailsBinding
    lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding.viewModel = viewModel
        binding.addButton.setOnClickListener {
            if (validateSize()) {
                viewModel.shoe.size = binding.addShoeSize.text.toString().toDouble()
            }
            if (validateName() && validateDetails() && validateCompany() && validateSize()) {
                viewModel.addToShoeList()
                findNavController().popBackStack()
            } else {
                val builder: AlertDialog.Builder? = activity?.let {
                    AlertDialog.Builder(it)
                }
                builder?.setMessage(R.string.invalid_input)
                    ?.setTitle("Invalid Input")
                val dialog: AlertDialog? = builder?.create()
                dialog?.show()
            }
        }
        binding.cancelButton.setOnClickListener {
            viewModel.clearShoe()
            findNavController().popBackStack()
        }
        return binding.root
    }

    private fun validateSize(): Boolean {
        if (binding.addShoeSize.text.isBlank()) {
            return false
        }
        return true
    }

    private fun validateDetails(): Boolean {
        if (binding.addShoeDetails.text.isBlank()) {
            return false
        }
        return true
    }

    private fun validateCompany(): Boolean {
        if (binding.addShoeCompany.text.isBlank()) {
            return false
        }
        return true
    }

    private fun validateName(): Boolean {
        if (binding.addShoeName.text.isBlank()) {
            return false
        }
        return true
    }
}