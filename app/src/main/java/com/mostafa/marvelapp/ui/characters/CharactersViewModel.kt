package com.mostafa.marvelapp.ui.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mostafa.marvelapp.data.State
import com.mostafa.marvelapp.data.repository.MarvelRepositoryImp
import com.mostafa.marvelapp.data.response.character.CharacterDto
import com.mostafa.marvelapp.data.response.character.Result
import com.mostafa.marvelapp.data.service.WepRequest
import com.mostafa.marvelapp.ui.base.BaseViewModel
import com.mostafa.marvelapp.utilies.Event
import com.mostafa.marvelapp.utilies.add
import com.mostafa.marvelapp.utilies.observeOnMainThread
import com.mostafa.marvelapp.utilies.postEvent

class CharactersViewModel : BaseViewModel(), CharactersInteractionListener {


    private val _requestState = MutableLiveData<State<CharacterDto>>(State.Loading)
    val requestState: LiveData<State<CharacterDto>> = _requestState

    private val _characterInfo = MutableLiveData<List<Result>?>()
    val characterInfo: LiveData<List<Result>?> = _characterInfo

    private val _navigateToDetails = MutableLiveData<Event<Int?>>()
    val navigateToDetails: LiveData<Event<Int?>> = _navigateToDetails

    private val _openExitDialog = MutableLiveData<Event<Boolean>>()
    val openExitDialog : LiveData<Event<Boolean>> = _openExitDialog

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        repository.getAllCharacters().run {
            observeOnMainThread()
            subscribe(::onGetCharactersSuccess, ::onGetQuestionsError)
                .add(disposable)
        }
    }


    private fun onGetCharactersSuccess(state: State<CharacterDto>) {
        if (state is State.Success) {
            _requestState.postValue(state)
            _characterInfo.postValue(state.data?.data?.results)


        } else {
            _requestState.postValue(state)
        }

    }

    private fun onGetQuestionsError(throwable: Throwable) {
        _requestState.postValue(State.Error(requireNotNull(throwable.message)))

    }

    override fun onClickedCharacter(character: Result) {
        _navigateToDetails.postEvent(character.id)

    }

    fun resetData(){
        _requestState.postValue(State.Loading)
        getAllCharacters()
    }


}


