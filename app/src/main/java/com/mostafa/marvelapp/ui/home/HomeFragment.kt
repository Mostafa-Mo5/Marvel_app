package com.mostafa.marvelapp.ui.home

import androidx.navigation.findNavController
import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.databinding.FragmentHomeBinding
import com.mostafa.marvelapp.ui.base.BaseFragment
import com.mostafa.marvelapp.utilies.observeEvent


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {
    override val viewModelClass: Class<HomeViewModel> = HomeViewModel::class.java


    override fun observeEvents() {
        viewModel.apply {
            navigateToCharacters.observeEvent(this@HomeFragment) {
                view?.findNavController()
                    ?.navigate(HomeFragmentDirections.actionHomeFragmentToCharactersFragment())

            }
            navigateToEvents.observeEvent(this@HomeFragment){
                view?.findNavController()
                    ?.navigate(HomeFragmentDirections.actionHomeFragmentToEventsFragment())
            }
        }
    }


}