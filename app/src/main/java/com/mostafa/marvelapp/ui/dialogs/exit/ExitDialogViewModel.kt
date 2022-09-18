package com.mostafa.marvelapp.ui.dialogs.exit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mostafa.marvelapp.ui.base.BaseViewModel
import com.mostafa.marvelapp.utilies.Event
import com.mostafa.marvelapp.utilies.postEvent

class ExitDialogViewModel : BaseViewModel() {

    private val _closeDialog = MutableLiveData<Event<Boolean>>()
    val closeDialog : LiveData<Event<Boolean>> = _closeDialog

    private val _navigateToHome = MutableLiveData<Event<Boolean>>()
    val navigateToHome : LiveData<Event<Boolean>> = _navigateToHome


    fun onClickCloseIcon() {
        _closeDialog.postEvent(true)
    }


    fun onClickExitButton() {
        _navigateToHome.postEvent(true)
    }
}