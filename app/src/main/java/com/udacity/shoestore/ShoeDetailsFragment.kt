package com.udacity.shoestore

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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
        (activity as AppCompatActivity)?.supportActionBar?.show()
        binding.addButton.setOnClickListener {
            try {
                try{
                    viewModel.shoe.size = binding.addShoeSize.text.toString().toDouble()
                }
                catch (e:Exception){
                    viewModel.shoe.size = 0.0
                }
                viewModel.validate()
                viewModel.addToShoeList()
                findNavController().popBackStack()
            }
            catch (e: Exception) {
                val builder: AlertDialog.Builder? = activity?.let {
                    AlertDialog.Builder(it)
                }
                builder?.setMessage(e.message)
                    ?.setTitle("Invalid Input")
                val dialog: AlertDialog? = builder?.create()
                dialog?.show()
            }
        }
        binding.cancelButton.setOnClickListener {
            viewModel.clearShoe()
            findNavController().popBackStack()
        }
        viewModel.clearShoe()
        viewModel.shoeIndex.observe(viewLifecycleOwner, Observer { getImage()})
        return binding.root
    }
    fun getImage() {
        binding.chooseShoeImage.setImageResource(viewModel.getImage())
    }
}