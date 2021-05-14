package com.miled.common.android.extentions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.miled.common.android.misc.DataWrapper
import com.miled.common.android.misc.Loading

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun <T> MutableLiveData<DataWrapper<T>>.setLoadingState(loading: Boolean) {
    this.value = Loading(loading)
}

fun RecyclerView.ViewHolder.getContext() = itemView.context