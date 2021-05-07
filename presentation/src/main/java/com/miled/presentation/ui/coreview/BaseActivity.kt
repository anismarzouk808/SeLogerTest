package com.miled.presentation.ui.coreview

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import com.miled.commun.utils.TAG_DIALOG_ERROR
import com.miled.presentation.R
import com.miled.presentation.dagger.factory.AppViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity(
    @LayoutRes private val layoutResId: Int
) : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    private var loadingView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        initView()
    }

    private fun initView() {
        loadingView = findViewById(R.id.loading_view)
    }

    fun toggleLoading(isLoading: Boolean) {
        loadingView?.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    fun toggleError(show: Boolean, errorMsg: String?) {
        if (show) {
            this.supportFragmentManager.let { fm ->
                CustomDialogFragment().apply {
                    title = R.string.text_error
                    description = R.string.message_error_has_occurred
                    positiveBtnName = R.string.text_Ok
                    positiveClickListener = {
                        dismiss()
                        recreate()
                    }
                }.show(fm, TAG_DIALOG_ERROR)
            }
        }
    }
}