package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.databinding.FragmentFormAcceptBinding
import com.example.myapplication.viewmodal.DetailViewModal
import com.example.myapplication.viewmodal.ResourceViewModel

class FormAccept : Fragment(){
    val TAG:String = "FORM ACCEPT"
    lateinit var binding: FragmentFormAcceptBinding
    lateinit var model : DetailViewModal
    lateinit var resourceModel : ResourceViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_form_accept, container, false)
        model = activity?.let {
            ViewModelProviders.of(it)[DetailViewModal::class.java]
        }!!
        resourceModel = activity?.let {
            ViewModelProviders.of(it)[ResourceViewModel::class.java]
        }!!
        binding.api = resourceModel
        resourceModel.callApi {
            Log.i("API", it)
        }
        setHasOptionsMenu(true)
        model.score.observe(viewLifecycleOwner, Observer {
            binding.formAcceptText.text = "Score: " + it.toString()
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            button.setOnClickListener{
                Navigation.findNavController(it).navigate(R.id.action_formAccept_to_detail)
            }
        }
    }
}