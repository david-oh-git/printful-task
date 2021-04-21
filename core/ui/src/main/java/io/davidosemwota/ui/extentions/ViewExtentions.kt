package io.davidosemwota.ui.extentions

import android.view.View

/**
 * Set [View] visibility with a boolean.
 */
var View.visible
    get() = visibility == View.VISIBLE
    set(value) {
        visibility = if (value) View.VISIBLE else View.GONE
    }