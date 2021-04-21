
package io.davidosemwota.ui.extentions

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import coil.load
import io.davidosemwota.ui.R
import kotlin.random.Random

/**
 * Set image loaded from url.
 *
 * @param url Image url to download and set as drawable.
 * @param placeholderId Drawable resource identifier to set while downloading image.
 */
fun AppCompatImageView.setImage(url: String, @DrawableRes placeholderId: Int?) {

    with(this) {
        load(url) {
            crossfade(true)
            placeholder(
                placeholderId?.let {
                    ContextCompat.getDrawable(context, it)
                } ?: run {
                    val placeholdersColors = resources.getStringArray(R.array.placeholders)
                    val placeholderColor = placeholdersColors[
                        Random.nextInt(placeholdersColors.size)
                    ]
                    ColorDrawable(Color.parseColor(placeholderColor))
                }
            )
        }
    }
}
