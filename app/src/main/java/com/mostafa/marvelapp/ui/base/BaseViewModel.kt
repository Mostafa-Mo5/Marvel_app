package com.mostafa.marvelapp.ui.base

import androidx.lifecycle.ViewModel
import com.mostafa.marvelapp.data.repository.MarvelRepositoryImp
import com.mostafa.marvelapp.data.service.WepRequest
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected val disposable = CompositeDisposable()


    protected val repository = MarvelRepositoryImp(WepRequest().apiService)

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()

    }

}