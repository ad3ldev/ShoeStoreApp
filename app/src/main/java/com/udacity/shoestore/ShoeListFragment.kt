package com.udacity.shoestore

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeViewBinding

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        val list = viewModel.shoeList.value
        if (list != null) {
            for (element in list) {
                val newShoe: ShoeViewBinding =
                    DataBindingUtil.inflate(inflater, R.layout.shoe_view, container, false)
                newShoe.shoeName.text = element.name
                newShoe.shoeSize.text = element.size.toString()
                newShoe.shoeCompany.text = element.company
                newShoe.shoeImage.setImageResource(R.drawable.ic_launcher_background)
                binding.linearLayout.addView(newShoe.root)
            }
        }
        binding.addShoeButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment())
        }
        val actionBar = (activity as AppCompatActivity)?.supportActionBar
        actionBar?.show()
        actionBar?.setDisplayHomeAsUpEnabled(false);
        setOnBackPressed()
        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.loginFragment ->{
                this.findNavController().popBackStack(R.id.loginFragment,false)
                true
            }else -> false
        }
    }

    private fun setOnBackPressed() {
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val intent = Intent()
                intent.action = Intent.ACTION_MAIN
                intent.addCategory(Intent.CATEGORY_HOME)
                startActivity(intent)
            }
        })
    }
}