package com.pepoc.stickerdemo.bitmapsaver;

import android.graphics.Bitmap;

/**
 * Interface designed for saving Bitmap object.
 *
 * @author ksayker
 * @version 0.1
 * @date 18.03.2016
 */
public interface BitmapSaver {
    /**
     * Save bitmap object.
     *
     * @param bitmap bitmap for saving.
     */
    void saveBitmap(Bitmap bitmap);
}
