package com.miled.presentation.ui.coreview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.miled.presentation.R

class CustomDialogFragment : DialogFragment() {

    var title: Int? = null
    var description: Int? = null
    var subDescription: String? = null
    var positiveBtnName: Int? = null
    var negativeBtnName: Int? = null

    var positiveClickListener: ((View) -> Unit)? = null
    var negativeClickListener: ((View) -> Unit)? = null

    private var titleTv: TextView? = null
    private var descriptionTv: TextView? = null
    private var positiveBtn: TextView? = null
    private var negativeBtn: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.custom_dialog_fragment, container, false)

        titleTv = view.findViewById(R.id.custom_dialog_text_title)
        descriptionTv = view.findViewById(R.id.custom_dialog_text_description)
        positiveBtn = view.findViewById(R.id.custom_dialog_text_positive)
        negativeBtn = view.findViewById(R.id.custom_dialog_text_negative)

        initViews()

        return view
    }

    private fun initViews() {
        isCancelable = false
        title?.let { titleTv?.text = getString(it) }
        description?.let { descriptionTv?.text = getString(it, subDescription) }
        positiveBtnName?.let { positiveBtn?.text = getString(it) }
        negativeBtnName?.let { negativeBtn?.text = getString(it) }

        positiveBtn?.setOnClickListener {
            dismiss()
            positiveClickListener?.invoke(it)
        }
        negativeBtn?.setOnClickListener {
            dismiss()
            negativeClickListener?.invoke(it)
        }
    }
}