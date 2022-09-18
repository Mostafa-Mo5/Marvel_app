package com.mostafa.marvelapp.ui.characters

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.data.State
import androidx.navigation.fragment.findNavController
import com.mostafa.marvelapp.databinding.FragmentCharactersBinding
import com.mostafa.marvelapp.ui.base.BaseFragment
import com.mostafa.marvelapp.utilies.observeEvent

class CharactersFragment :
    BaseFragment<FragmentCharactersBinding, CharactersViewModel>(R.layout.fragment_characters) {
    override val viewModelClass: Class<CharactersViewModel> = CharactersViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.resetData()
        setOnBackButtonClickListener()
    }


    override fun observeEvents() {
        viewModel.apply {
            navigateToDetails.observeEvent(this@CharactersFragment){
                view?.findNavController()
                    ?.navigate(CharactersFragmentDirections.actionCharactersFragmentToDetailsFragment2(it?:0))
            }
            openExitDialog.observeEvent(this@CharactersFragment) {
                showExitDialog()
            }
        }
    }

    private fun setOnBackButtonClickListener() {
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (viewModel.requestState.value is State.Success) {
                    showExitDialog()
                } else {
                    findNavController().popBackStack()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)
    }
    private fun showExitDialog() {
        requireView().findNavController()
            .navigate(CharactersFragmentDirections.actionCharactersFragmentToExitDialogFragment())
    }



}