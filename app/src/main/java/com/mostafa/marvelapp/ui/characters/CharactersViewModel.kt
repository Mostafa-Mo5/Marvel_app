package com.mostafa.marvelapp.ui.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.Glide
import com.mostafa.marvelapp.data.State
import com.mostafa.marvelapp.data.repository.MarvelRepositoryImp
import com.mostafa.marvelapp.data.response.base.Thumbnail
import com.mostafa.marvelapp.data.response.characters.CharacterDto
import com.mostafa.marvelapp.data.service.WepRequest
import com.mostafa.marvelapp.ui.base.BaseViewModel
import com.mostafa.marvelapp.utilies.add
import com.mostafa.marvelapp.utilies.observeOnMainThread

class CharactersViewModel : BaseViewModel(), CharactersInteractionListener {

    private val repository = MarvelRepositoryImp(WepRequest().apiService)


    private val _requestState = MutableLiveData<State<CharacterDto>>(State.Loading)
    val requestState: LiveData<State<CharacterDto>> get() = _requestState

    private val _characterName = MutableLiveData<String?>()
    val characterName: LiveData<String?> = _characterName

    private val _description = MutableLiveData<String?>()
    val description: LiveData<String?> = _description

    private val _thumbnailOfCharacter = MutableLiveData<String?>()
    val thumbnailOfCharacter: LiveData<String?> = _thumbnailOfCharacter


    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        repository.getAllCharacters().run {
            observeOnMainThread()
            subscribe(::onGetCharactersSuccess, ::onGetQuestionsError)
        }.add(compositeDisposable)
    }


    private fun onGetCharactersSuccess(state: State<CharacterDto>) {
        if (state is State.Success) {
            _characterName.postValue(state.data?.name)
            _description.postValue(state.data?.description)
            convertToUrl(state)

        } else {
            _requestState.postValue(state)
        }
    }

    private fun convertToUrl(state: State<CharacterDto>) {
        _thumbnailOfCharacter.postValue(state.toData()?.thumbnail?.run { "$path.$extension" })
        Log.i("TESTING",_thumbnailOfCharacter.toString())
    }

    private fun onGetQuestionsError(throwable: Throwable) {
        _requestState.postValue(State.Error(requireNotNull(throwable.message)))

    }

}


