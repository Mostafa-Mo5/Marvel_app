package com.mostafa.marvelapp.data.repository

import com.mostafa.marvelapp.data.State
import com.mostafa.marvelapp.data.response.characters.CharacterDto
import com.mostafa.marvelapp.data.response.comics.ComicDto
import io.reactivex.rxjava3.core.Observable


interface MarvelRepository {
 fun getAllCharacters():Observable<State<CharacterDto>>

 fun getAllComics():Observable<State<ComicDto>>
}