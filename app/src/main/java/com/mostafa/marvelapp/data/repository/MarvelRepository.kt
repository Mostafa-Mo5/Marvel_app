package com.mostafa.marvelapp.data.repository

import com.mostafa.marvelapp.data.State
import com.mostafa.marvelapp.data.response.character.CharacterDto
import com.mostafa.marvelapp.data.response.comics.ComicDto
import com.mostafa.marvelapp.data.response.events.EventDto
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single


interface MarvelRepository {
 fun getAllCharacters(): Single<State<CharacterDto>>

 fun getAllComics(id:Int): Single<State<ComicDto>>

 fun getAllEvents():Single<State<EventDto>>
}