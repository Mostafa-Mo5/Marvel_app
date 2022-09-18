package com.mostafa.marvelapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mostafa.marvelapp.ui.base.BaseViewModel
import com.mostafa.marvelapp.utilies.Event
import com.mostafa.marvelapp.utilies.postEvent

class HomeViewModel : BaseViewModel() {


    private val _navigateToCharacters = MutableLiveData<Event<Boolean>>()
    val navigateToCharacters: LiveData<Event<Boolean>> = _navigateToCharacters

    private val _navigateToEvents = MutableLiveData<Event<Boolean>>()
    val navigateToEvents: LiveData<Event<Boolean>> = _navigateToEvents

    fun onClickGoToCharactersViewButton() {
        _navigateToCharacters.postEvent(true)
    }

    fun onClickGoToEventsViewButton() {
        _navigateToEvents.postEvent(true)
    }
}