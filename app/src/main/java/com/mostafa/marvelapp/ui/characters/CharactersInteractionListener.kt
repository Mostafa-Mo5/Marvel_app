package com.mostafa.marvelapp.ui.characters

import com.mostafa.marvelapp.data.response.character.Result
import com.mostafa.marvelapp.ui.base.BaseInteractionListener

interface CharactersInteractionListener : BaseInteractionListener {
    fun onClickedCharacter(character: Result)
}