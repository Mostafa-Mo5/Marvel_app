package com.mostafa.marvelapp.ui.characters

import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.data.response.characters.CharacterDto
import com.mostafa.marvelapp.ui.base.BaseAdapter

class CharactersAdapter(var list: List<CharacterDto>, listener: CharactersInteractionListener) :
    BaseAdapter<CharacterDto>(list, listener) {
    override val layoutID = R.layout.item_characters
}