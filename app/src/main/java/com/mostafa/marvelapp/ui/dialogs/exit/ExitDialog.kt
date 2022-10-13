package com.mostafa.marvelapp.ui.dialogs.exit

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.databinding.FragmentDialogExitBinding
import com.mostafa.marvelapp.ui.base.BaseDialogFragment
import com.mostafa.marvelapp.utilies.observeEvent

class ExitDialogFragment : BaseDialogFragment<FragmentDialogExitBinding>() {
    override val layoutId = R.layout.fragment_dialog_exit
    override fun bindingInflater() = FragmentDialogExitBinding.inflate(layoutInflater)
    val viewModel: ExitDialogViewModel by viewModels()
    override fun setup() {
        binding.apply {
            lifecycleOwner = this@ExitDialogFragment
            this.viewModel = this@ExitDialogFragment.viewModel
        }
        handleObserveEvents()
    }

    private fun handleObserveEvents() {
        viewModel.apply {
            closeDialog.observeEvent(this@ExitDialogFragment) {
                this@ExitDialogFragment.findNavController().popBackStack()
            }

            navigateToHome.observeEvent(this@ExitDialogFragment) {
                this@ExitDialogFragment.findNavController().popBackStack(R.id.homeFragment,false)
            }
        }
    }

}