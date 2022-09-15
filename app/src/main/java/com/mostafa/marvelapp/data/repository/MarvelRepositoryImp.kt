package com.mostafa.marvelapp.data.repository

import com.mostafa.marvelapp.data.State
import com.mostafa.marvelapp.data.response.characters.CharacterDto
import com.mostafa.marvelapp.data.response.comics.ComicDto
import com.mostafa.marvelapp.data.service.MarvelApiService
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class MarvelRepositoryImp(private val marvelApiService: MarvelApiService) : MarvelRepository {

    override fun getAllCharacters(): Observable<State<CharacterDto>> {
        return wrapWithObservable(marvelApiService::getAllCharacters)
    }

    override fun getAllComics(): Observable<State<ComicDto>> {
        return wrapWithObservable(marvelApiService::getAllComics)
    }


}


private fun <T> wrapWithObservable(requestFunction: () -> Observable<Response<T>>): Observable<State<T>> =
    Observable.create { emitter ->
        emitter.onNext(State.Loading)
        try {
            requestFunction().subscribe(
                {
                    emitter.onNext(State.Success(it.body()))
                }, {
                    emitter.onNext(State.Error(it.message.toString()))
                }
            )
        } catch (e: Exception) {
            emitter.onNext(State.Error(e.message.toString()))
        }
    }