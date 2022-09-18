package com.mostafa.marvelapp.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mostafa.marvelapp.data.State
import com.mostafa.marvelapp.data.repository.MarvelRepositoryImp

import com.mostafa.marvelapp.data.response.comics.ComicDto
import com.mostafa.marvelapp.data.response.comics.Result
import com.mostafa.marvelapp.data.service.WepRequest
import com.mostafa.marvelapp.ui.base.BaseViewModel
import com.mostafa.marvelapp.utilies.add
import com.mostafa.marvelapp.utilies.observeOnMainThread

class DetailsViewModel : BaseViewModel(), DetailsInteractionsListener {


    private val _requestState = MutableLiveData<State<ComicDto>>(State.Loading)
    val requestState: LiveData<State<ComicDto>> = _requestState

    private val _detailsInfo = MutableLiveData<List<Result>?>()
    val detailsInfo: LiveData<List<Result>?> = _detailsInfo



    fun getAllComicsOfCharactersById(id: Int) {
        _requestState.postValue(State.Loading)
        repository.getAllComics(id).observeOnMainThread()
            .subscribe(::onGetDetailsSuccess, ::onGetDetailsError)
            .add(disposable)

    }


    private fun onGetDetailsSuccess(state: State<ComicDto>) {
        if (state is State.Success) {
            _detailsInfo.postValue(state.data?.data?.results)
            _requestState.postValue(state)

        } else {
            _requestState.postValue(state)
        }

    }

    private fun onGetDetailsError(throwable: Throwable) {

        _requestState.postValue(State.Error(requireNotNull(throwable.message)))

    }

}