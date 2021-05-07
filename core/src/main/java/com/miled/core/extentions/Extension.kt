package com.miled.core.extentions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.miled.core.misc.DataWrapper
import com.miled.core.misc.Loading

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

fun <T> MutableLiveData<DataWrapper<T>>.setLoadingState(loading: Boolean) {
    this.value = Loading(loading)
}

fun RecyclerView.ViewHolder.getContext() = itemView.context