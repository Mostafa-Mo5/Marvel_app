package com.mostafa.marvelapp.ui.events

import com.mostafa.marvelapp.R
import com.mostafa.marvelapp.data.response.events.Result
import com.mostafa.marvelapp.ui.base.BaseAdapter

class EventsAdapter(var list: List<Result>, listener: EventsInteractionsListener) :
    BaseAdapter<Result>(list, listener) {
    override val layoutID = R.layout.item_event
}