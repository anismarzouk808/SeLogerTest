package com.miled.core.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.miled.core.R
import com.miled.core.databinding.CommonandroidLayoutErrorBinding

class ErrorView : ConstraintLayout {

    @VisibleForTesting
    internal val binding =
        CommonandroidLayoutErrorBinding.inflate(LayoutInflater.from(context), this, true)


    constructor(context: Context) : super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.ErrorView)
            try {
                val title = typedArray.getString(R.styleable.ErrorView_ErrorViewMessage)
                val message = typedArray.getString(R.styleable.ErrorView_ErrorViewTitle)
                binding.errorTitle.text = title
                binding.errorMessage.text = message
            } finally {
                typedArray.recycle()
            }
        }
    }

    fun setRetryListener(block: (() -> Unit)) {
        binding.retryButton.setOnClickListener {
            this@ErrorView.visibility = View.GONE
            block.invoke()
        }
    }

    private fun setMessagesError(@StringRes title: Int, @StringRes message: Int?) {
        binding.errorTitle.text = context.getString(title)

        binding.errorMessage.isVisible = message != null
        message?.let { binding.errorMessage.text = context.getString(it) }
    }

    private fun setMessagesError(title: String, message: String?) {
        binding.errorTitle.text = title

        binding.errorMessage.isVisible = message != null
        message?.let { binding.errorMessage.text = it }
    }

    fun setProperties(
        @StringRes title: Int,
        @StringRes message: Int?,
        retryBtnVisible: Boolean = false
    ) {

        binding.retryButton.isVisible = retryBtnVisible
        setMessagesError(title, message)
    }

    fun setProperties(
        title: String,
        message: String? = null,
        retryBtnVisible: Boolean = false
    ) {

        binding.retryButton.isVisible = retryBtnVisible
        setMessagesError(title, message)
    }
}