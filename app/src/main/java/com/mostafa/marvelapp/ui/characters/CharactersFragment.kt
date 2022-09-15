package com.mostafa.marvelapp.ui.characters

import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.databinding.FragmentCharactersBinding
import com.mostafa.marvelapp.ui.base.BaseFragment

class CharactersFragment :
    BaseFragment<FragmentCharactersBinding, CharactersViewModel>(R.layout.fragment_characters) {
    override val viewModelClass: Class<CharactersViewModel> = CharactersViewModel::class.java

    override fun observeEvents() {
        if (true){}
    }


}