package com.mostafa.marvelapp.ui.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.databinding.FragmentsDetailsBinding
import com.mostafa.marvelapp.ui.base.BaseFragment


class DetailsFragment :
    BaseFragment<FragmentsDetailsBinding, DetailsViewModel>(R.layout.fragments_details) {
    override val viewModelClass: Class<DetailsViewModel> = DetailsViewModel::class.java

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllComicsOfCharactersById(args.id)

        binding.recyclerDetails.adapter = DetailsAdapter(mutableListOf(), viewModel)
    }

    override fun observeEvents() {}
}