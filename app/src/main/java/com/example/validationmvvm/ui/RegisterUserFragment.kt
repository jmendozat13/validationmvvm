package com.example.validationmvvm.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.validationmvvm.R
import com.example.validationmvvm.databinding.RegisteruserFragmentBinding
import com.google.android.material.snackbar.Snackbar


class RegisterUserFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterUserFragment()
    }

    private lateinit var viewModel: RegisterUserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(RegisterUserViewModel::class.java)
        val binding: RegisteruserFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.registeruser_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { message ->
            Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show()
        })
    }

}