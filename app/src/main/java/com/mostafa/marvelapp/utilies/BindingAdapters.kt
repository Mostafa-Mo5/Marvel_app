package com.mostafa.marvelapp.utilies

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.imageview.ShapeableImageView
import com.mostafa.marvelapp.ui.base.BaseAdapter
import com.mostafa.marvelapp.ui.characters.CharactersAdapter
import com.mostafa.marvelapp.ui.characters.CharactersViewModel


@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    (view.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:setAdapter"])
fun setGameAdapter(view: RecyclerView, viewModel: CharactersViewModel) {
    view.adapter = CharactersAdapter(mutableListOf(), viewModel)
}

@BindingAdapter(value = ["app:textFormattingBySymbols"])
fun formatTextBySymbols(view: TextView, text: String?) {
    view.text = text?.replacePunctuationTextsWithSymbols()
}

@BindingAdapter("image")
fun ShapeableImageView.setImage(imageUrl: String?) = Glide.with(context)
    .load(imageUrl)
    .transition(DrawableTransitionOptions.withCrossFade())
    .into(this)
