package com.mostafa.marvelapp.ui.events

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.data.State
import com.mostafa.marvelapp.databinding.FragmentEventsBinding
import com.mostafa.marvelapp.ui.base.BaseFragment
import com.mostafa.marvelapp.ui.characters.CharactersFragmentDirections
import com.mostafa.marvelapp.utilies.observeEvent

class EventsFragment :
    BaseFragment<FragmentEventsBinding, EventsViewModel>(R.layout.fragment_events) {
    override val viewModelClass: Class<EventsViewModel> = EventsViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.resetData()
        setOnBackButtonClickListener()
    }


    override fun observeEvents() {
        viewModel.apply {
            openExitDialog.observeEvent(this@EventsFragment) {
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
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            onBackPressedCallback
        )
    }

    private fun showExitDialog() {
        requireView().findNavController()
            .navigate(EventsFragmentDirections.actionEventsFragmentToExitDialogFragment())
    }
}