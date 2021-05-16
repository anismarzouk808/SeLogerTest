package com.miled.common

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.text.DecimalFormat


fun Int.toPriceFormat(): String {
    val dec = DecimalFormat("#,###,###€")
    return dec.format(this)
}

fun Disposable.disposeBy(compositeDisposable: CompositeDisposable): Disposable =
    this.apply { compositeDisposable.add(this) }


val <T> T.exhaustive: T
    get() = this