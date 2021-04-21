package io.davidosemwota.ui.extentions

import android.content.Context
import androidx.fragment.app.Fragment
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialElevationScale

const val SHARED_ELEMENT_TRANSITION_DURATION = 400L

fun Fragment.setSharedElementTransitions(
    enterTransitionSetup: (MaterialContainerTransform.() -> Unit)? = null,
    returnTransitionSetup: (MaterialContainerTransform.() -> Unit)? = null,
) {
    val context = requireContext()
    sharedElementEnterTransition = context.buildSharedElementTransition(enterTransitionSetup)
    sharedElementReturnTransition = context.buildSharedElementTransition(returnTransitionSetup)
    setExitSharedElementTransition()
}

fun Fragment.setExitSharedElementTransition() {
    exitTransition = MaterialElevationScale(/* growing= */ false).apply {
        duration = SHARED_ELEMENT_TRANSITION_DURATION
    }
    reenterTransition = MaterialElevationScale(/* growing= */ true).apply {
        duration = SHARED_ELEMENT_TRANSITION_DURATION
    }
}

private fun Context.buildSharedElementTransition(
    setup: (MaterialContainerTransform.() -> Unit)?
): MaterialContainerTransform {
    val shapeAppearance = ShapeAppearanceModel().withCornerSize(dpToPx(16).toFloat())
    return MaterialContainerTransform().apply {
        startShapeAppearanceModel = shapeAppearance
        duration = SHARED_ELEMENT_TRANSITION_DURATION
        fadeMode = MaterialContainerTransform.FADE_MODE_CROSS
        containerColor = getAttributeColor(android.R.attr.colorBackground)
        setup?.invoke(this)
    }
}