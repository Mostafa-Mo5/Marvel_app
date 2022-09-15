package com.mostafa.marvelapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.mostafa.marvelapp.BR

abstract class BaseFragment<VDB : ViewDataBinding, VM : ViewModel>(private val layoutId: Int) :
    Fragment() {

    lateinit var viewModel: VM
    abstract val viewModelClass: Class<VM>


    private lateinit var _binding: VDB
    val binding: VDB get() = _binding

    abstract fun observeEvents()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        _binding.apply {
            setVariable(BR.viewModel, this@BaseFragment.viewModel)
            lifecycleOwner = this@BaseFragment
            return root
        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity())[viewModelClass]
    }

    fun navigate(action: NavDirections) {
        findNavController().navigate(action)
    }

    fun popBackStack(id: Int) {
        findNavController().popBackStack(id, false)
    }

    fun popBackStack() {
        findNavController().popBackStack()
    }

    override fun onStart() {
        super.onStart()
        observeEvents()
    }
}