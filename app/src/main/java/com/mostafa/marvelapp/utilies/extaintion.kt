package com.mostafa.marvelapp.utilies

import androidx.lifecycle.LiveData
import com.mostafa.marvelapp.data.response.base.Thumbnail
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils.md5
import org.jsoup.Jsoup


fun String.toMD5(): String = Hex.encodeHexString(md5(this))

fun <T : Any> Observable<T>.observeOnMainThread(): Observable<T> {
    return subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun Disposable.add(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun String.replacePunctuationTextsWithSymbols(): String = Jsoup.parse(this).text()

fun LiveData<Thumbnail>.makeUrl(): String {
    return this.value?.extension+this.value?.path
}
