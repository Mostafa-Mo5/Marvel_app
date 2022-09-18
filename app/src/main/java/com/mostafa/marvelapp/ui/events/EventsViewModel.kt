package com.mostafa.marvelapp.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mostafa.marvelapp.data.State
import com.mostafa.marvelapp.data.response.events.Result
import com.mostafa.marvelapp.data.response.events.EventDto
import com.mostafa.marvelapp.ui.base.BaseViewModel
import com.mostafa.marvelapp.utilies.Event
import com.mostafa.marvelapp.utilies.add
import com.mostafa.marvelapp.utilies.observeOnMainThread

class EventsViewModel : BaseViewModel(), EventsInteractionsListener {


    private val _requestState = MutableLiveData<State<EventDto>>(State.Loading)
    val requestState: LiveData<State<EventDto>> = _requestState

    private val _eventsInfo = MutableLiveData<List<Result>?>()
    val eventsInfo: LiveData<List<Result>?> = _eventsInfo

    private val _openExitDialog = MutableLiveData<Event<Boolean>>()
    val openExitDialog: LiveData<Event<Boolean>> = _openExitDialog

    init {
        getAllEvents()
    }

    private fun getAllEvents() {
        repository.getAllEvents().run {
            observeOnMainThread()
            subscribe(::onGetCharactersSuccess, ::onGetQuestionsError)
                .add(disposable)
        }
    }

    private fun onGetCharactersSuccess(state: State<EventDto>) {
        if (state is State.Success) {
            _requestState.postValue(state)
            _eventsInfo.postValue(state.data?.data?.results)

        } else {
            _requestState.postValue(state)
        }

    }

    private fun onGetQuestionsError(throwable: Throwable) {
        _requestState.postValue(State.Error(requireNotNull(throwable.message)))

    }

    fun resetData() {
        _requestState.postValue(State.Loading)
        getAllEvents()
    }

}