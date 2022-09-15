package com.mostafa.marvelapp.ui.home

import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.databinding.FragmentHomeBinding
import com.mostafa.marvelapp.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(R.layout.fragment_home) {
    override val viewModelClass: Class<HomeViewModel> =HomeViewModel::class.java


    override fun observeEvents() {
        if (true){}
    }


}