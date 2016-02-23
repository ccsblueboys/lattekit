package io.lattekit.plugin.css.property

import android.content.res.ColorStateList
import android.graphics.Color.TRANSPARENT
import android.graphics.drawable.*
import android.os.Build
import io.lattekit.ui.view.NativeView

/**
 * Created by maan on 2/22/16.
 */
fun getBackgroundLayerDrawable(view: NativeView): LayerDrawable {
    var backgroundDrawable = view.data("css:backgroundLayerDrawable")
    if (backgroundDrawable == null) {
        backgroundDrawable = LayerDrawable(arrayOf(ColorDrawable(), ColorDrawable(), ColorDrawable()))
        backgroundDrawable?.setId(0, 0)
        backgroundDrawable?.setId(1, 1)
        backgroundDrawable?.setId(2, 2)

        // TODO Shape and Ripple
        var shapeDrawable = ShapeDrawable();
        view.data("css:shapeDrawable", shapeDrawable)
        var rippleColor = ColorStateList(arrayOf(intArrayOf()), intArrayOf(TRANSPARENT));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.androidView?.background = RippleDrawable(rippleColor, backgroundDrawable, shapeDrawable);
        } else {
            view.androidView?.background = codetail.graphics.drawables.RippleDrawable(rippleColor, backgroundDrawable, shapeDrawable);
        }
        view.data("css:backgroundLayerDrawable", backgroundDrawable)
    }
    return backgroundDrawable as LayerDrawable
}

class BackgroundColorCssProperty : ColorProperty() {

    override val PROPERTY_NAME = "background-color"
    override val INHERITED = true
    override val INITIAL_VALUE: String? = "white"

    var backgroundGradientDrawable: GradientDrawable? = null

    override fun apply(view: NativeView) {

        if (backgroundGradientDrawable == null) {
            backgroundGradientDrawable = GradientDrawable()
        }
        backgroundGradientDrawable?.setColors(listOf(computedValue!!, computedValue!!).toIntArray())

        getBackgroundLayerDrawable(view).setDrawableByLayerId(0, backgroundGradientDrawable)

    }
}

