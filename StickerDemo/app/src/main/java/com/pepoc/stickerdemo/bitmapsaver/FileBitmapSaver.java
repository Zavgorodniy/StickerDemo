package com.pepoc.stickerdemo.bitmapsaver;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class designed for saving Bitmap object to PNG file.
 * File save to: Pictures/Football.
 *
 * @author ksayker
 * @version 0.1
 * @date 18.03.2016
 */
public class FileBitmapSaver implements BitmapSaver {
    /** Path to the football directory.*/
    private String mFootballDirPath = "Pictures//Football";
    /** Pattern for file name.*/
    private String mFileNamePattern = "football party";
    /** File mExtension.*/
    private String mExtension = ".png";
    /** File name for saving data.*/
    private String mFileName;

    /** Picture quality*/
    private final int PICTURE_QUALITY;

    /**
     * Create object with max picture quality.
     */
    public FileBitmapSaver() {
        this.PICTURE_QUALITY = 100;
    }

    /**
     * Save bitmap object to image.png file. When file already exist
     * to file name add some number in brackets.
     *
     * @param bitmap bitmap for saving.
     */
    @Override
    public void saveBitmap(Bitmap bitmap) {
        //reading file structure
        File cdCardDir = Environment.getExternalStorageDirectory();
        File footballDir = new File(cdCardDir, mFootballDirPath);
        boolean isDirExists = footballDir.exists();
        if (!isDirExists) {
            isDirExists = footballDir.mkdir();
        }
        if (isDirExists) {
            File[] files = footballDir.listFiles();
            //list with file names that contained in directory with out file extension
            List<String> shortFileNames = new LinkedList<>();
            for (File file : files) {
                String fullFileName = file.getName();
                shortFileNames.add(fullFileName
                        .substring(0, fullFileName.lastIndexOf(mExtension)));
            }

            //chose file name for current bitmap
            if (shortFileNames.contains(mFileNamePattern)) {
                int i = 1;
                while (true) {
                    mFileName = mFileNamePattern + " (" + i + ")";
                    if (!shortFileNames.contains(mFileName)) {
                        break;
                    }
                    i++;
                }
                mFileName += mExtension;
            } else {
                mFileName = mFileNamePattern + mExtension;
            }

            //saving bitmap to file
            File bitmapFile = new File(footballDir, mFileName);
            try {
                FileOutputStream out = new FileOutputStream(bitmapFile);
                bitmap.compress(Bitmap.CompressFormat.PNG, PICTURE_QUALITY, out);
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
