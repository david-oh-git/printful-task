package io.davidosemwota.ui.extentions

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes

fun Context.getAttributeColor(@AttrRes attrRes: Int): Int {
    val typedValue = TypedValue()
    this.theme.resolveAttribute(attrRes, typedValue, true)
    return typedValue.data
}

fun Context.dpToPx(dpValue: Int): Int = (dpValue * resources.displayMetrics.density).toInt()