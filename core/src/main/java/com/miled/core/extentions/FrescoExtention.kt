package com.miled.core.extentions

import android.graphics.drawable.Animatable
import android.net.Uri
import android.view.ViewGroup
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.BaseControllerListener
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.image.ImageInfo

fun SimpleDraweeView.loadUrl(url: String?) {
    loadUri(url?.let { Uri.parse(it) })
}

fun SimpleDraweeView.loadUri(uri: Uri?) {
    with(Fresco.newDraweeControllerBuilder()) {
        setUri(uri)
        oldController = controller
        controllerListener = object : BaseControllerListener<ImageInfo>() {

            private fun updateView(info: ImageInfo) {
                layoutParams.let {
                    if (it.width == ViewGroup.LayoutParams.WRAP_CONTENT || it.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
                        aspectRatio = info.width.toFloat() / info.height
                    }
                }
            }

            override fun onFinalImageSet(
                id: String?,
                imageInfo: ImageInfo?,
                animatable: Animatable?
            ) {
                super.onFinalImageSet(id, imageInfo, animatable)
                imageInfo?.let { updateView(it) }
            }

            override fun onIntermediateImageSet(id: String?, imageInfo: ImageInfo?) {
                super.onIntermediateImageSet(id, imageInfo)
                imageInfo?.let { updateView(it) }
            }
        }
        build()
    }.let {
        controller = it
    }
}