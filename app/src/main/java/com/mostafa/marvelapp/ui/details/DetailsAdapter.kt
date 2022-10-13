package com.mostafa.marvelapp.ui.details

import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.data.response.character.Result
import com.mostafa.marvelapp.ui.base.BaseAdapter

class DetailsAdapter (var list: List<Result>, listener: DetailsInteractionsListener) :
    BaseAdapter<Result>(list, listener) {
    override val layoutID = R.layout.item_details
}
