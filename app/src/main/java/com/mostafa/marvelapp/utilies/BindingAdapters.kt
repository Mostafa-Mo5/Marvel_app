package com.mostafa.marvelapp.utilies

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mostafa.marvelapp.data.State
import com.mostafa.marvelapp.ui.base.BaseAdapter
import com.mostafa.marvelapp.ui.characters.CharactersAdapter
import com.mostafa.marvelapp.ui.characters.CharactersViewModel
import com.mostafa.marvelapp.ui.details.DetailsAdapter
import com.mostafa.marvelapp.ui.details.DetailsViewModel
import com.mostafa.marvelapp.ui.events.EventsAdapter
import com.mostafa.marvelapp.ui.events.EventsViewModel


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:setCharacterAdapter"])
fun setCharacterAdapter(view: RecyclerView, viewModel: CharactersViewModel) {
    view.adapter = CharactersAdapter(mutableListOf(), viewModel)
}

@BindingAdapter(value = ["app:setDetailsAdapter"])
fun setDetailsAdapter(view: RecyclerView, viewModel: DetailsViewModel) {
    view.adapter = DetailsAdapter(mutableListOf(), viewModel)
}

@BindingAdapter(value = ["app:setEventsAdapter"])
fun setEventsAdapter(view: RecyclerView, viewModel: EventsViewModel) {
    view.adapter = EventsAdapter(mutableListOf(), viewModel)
}

@BindingAdapter(value = ["app:textFormattingBySymbols"])
fun formatTextBySymbols(view: TextView, text: String?) {
    view.text = text?.replacePunctuationTextsWithSymbols()
}

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?) {
    Log.i("TESTING",state.toString())
    when (state) {
        is State.Loading -> view.show()
        else -> view.hide()
    }
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?) {
    Log.i("TESTING",state.toString())
    when (state) {
        is State.Error -> view.show()
        else -> view.hide()
    }
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    Log.i("TESTING",state.toString())
    when (state) {
        is State.Success -> view.show()
        else -> view.hide()
    }
}


@BindingAdapter(value = ["app:image"])
fun setImageByUrl(view: ImageView, url: String?) {
    if (url != null) {
        with(view) {
            loadImageUrl(url)
        }
    }
}

