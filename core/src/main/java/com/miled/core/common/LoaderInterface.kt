package com.miled.core.common

import android.annotation.SuppressLint
import android.view.View
import androidx.core.view.isVisible
import com.miled.core.R

interface LoaderInterface {

    val loaderContainer: View
    private val requestLoader get() = loaderContainer.findViewById<View>(R.id.progress)
    private val maskView get() = loaderContainer.findViewById<View>(R.id.maskView)

    @SuppressLint("ClickableViewAccessibility")
    fun showRequestLoader() {
        with(maskView) {
            isVisible = true
            setOnTouchListener { _, _ -> true }
        }
        requestLoader.isVisible = true
    }

    fun hideRequestLoader() {
        maskView.isVisible = false
        requestLoader.isVisible = false
    }
}
