package com.example.validationmvvm.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.validationmvvm.R
import com.example.validationmvvm.databinding.RegisteruserFragmentBinding


class RegisterUserFragment : Fragment() {

    companion object {
        fun newInstance() = RegisterUserFragment()
    }

    private lateinit var viewModel: RegisterUserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: RegisteruserFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.registeruser_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterUserViewModel::class.java)
    }

}