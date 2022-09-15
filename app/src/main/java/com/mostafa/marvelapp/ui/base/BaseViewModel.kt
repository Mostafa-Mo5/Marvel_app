package com.mostafa.marvelapp.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    val compositeDisposable : CompositeDisposable by lazy { CompositeDisposable() }

//    protected val gameRepository = GameRepositoryImpl(API.apiService, StateWrapper())

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}