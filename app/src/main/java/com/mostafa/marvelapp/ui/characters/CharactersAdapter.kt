package com.mostafa.marvelapp.ui.characters

import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.data.response.character.CharacterDto
import com.mostafa.marvelapp.data.response.character.Result
import com.mostafa.marvelapp.ui.base.BaseAdapter

class CharactersAdapter(var list: List<Result>, listener: CharactersInteractionListener) :
    BaseAdapter<Result>(list, listener) {
    override val layoutID = R.layout.item_characters
}