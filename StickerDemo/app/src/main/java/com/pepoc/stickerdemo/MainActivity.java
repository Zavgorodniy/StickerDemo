package com.pepoc.stickerdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final StickerView stickerView = (StickerView)findViewById(R.id.sticker_view);

        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        final Bitmap bgBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.bg_login_guide);
        stickerView.setWaterMark(bitmap, bgBitmap);

        findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickerView.saveBitmapToFile();
            }
        });

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stickerView.setWaterMark(bitmap, bgBitmap);
            }
        });
    }

}
