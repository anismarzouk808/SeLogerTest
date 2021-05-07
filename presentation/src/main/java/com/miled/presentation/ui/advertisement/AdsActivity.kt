package com.miled.presentation.ui.advertisement

import com.miled.presentation.R
import com.miled.presentation.ui.coreview.BaseActivity

class AdsActivity : BaseActivity(R.layout.all_ads_activity) {
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
