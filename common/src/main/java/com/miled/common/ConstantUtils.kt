package com.miled.common

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.text.DecimalFormat

const val TAG_DIALOG_ERROR = "custom dialog error"

fun Int.toPriceFormat(): String {
    val dec = DecimalFormat("#,###,###€")
    return dec.format(this).replaceAfter(",", "")
}

fun Disposable.disposeBy(compositeDisposable: CompositeDisposable): Disposable =
    this.apply { compositeDisposable.add(this) }


val <T> T.exhaustive: T
    get() = this