package com.example.bearg.designmaterial;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by bearg on 5/31/2016.
 */
public final class ColorUtils {

    private ColorUtils() {
        throw new AssertionError("Class not supposed to be instantiated");
    }

    public static int getThemeColor(final Context context, final int attributeColor) {
        final TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(attributeColor, value, true);
        return value.data;
    }
}
