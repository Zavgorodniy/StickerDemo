package com.pepoc.stickerdemo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * Created by yangchen on 15-9-10.
 */
public class Utils {

    private static Point point = null;

    public static Point getDisplayWidthPixels(Context context) {
        if (point != null) {
            return point;
        }
        WindowManager wm = ((Activity)context).getWindowManager();
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        return point;
    }
}
