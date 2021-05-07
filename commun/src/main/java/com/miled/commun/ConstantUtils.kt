package com.miled.commun.utils

import java.text.DecimalFormat

const val TAG_DIALOG_ERROR = "custom dialog error"

fun Int.toPriceFormat(): String {
    val dec = DecimalFormat("#,###,###€")
    return dec.format(this).replaceAfter(",", "")
}