package com.example.dzhu_intrepid.tiletilerevolution.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ImageHelper {

    public static Bitmap[] splitBitmap(Bitmap originalBitmap, int dimension) {
        if (originalBitmap == null) {
            return null;
        }

        int width = originalBitmap.getWidth() / dimension;
        int height = originalBitmap.getHeight() / dimension;
        Bitmap[] bitmapHolder = new Bitmap[dimension * dimension];

        for (int yIndex = 0; yIndex < dimension; yIndex++) {
            for (int xIndex = 0; xIndex < dimension; xIndex++) {
                bitmapHolder[xIndex * dimension + yIndex] = Bitmap.createBitmap(
                        originalBitmap, width * xIndex, height * yIndex, width, height);
            }
        }

        return bitmapHolder;
    }

    public static byte[] serializeImage(Bitmap bitmapImage) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public static byte[][] serializeImages(Bitmap[] bitmapImages) {
        int length = bitmapImages.length;
        byte[][] serialized = new byte[length][];

        for (int bitmapIndex = 0; bitmapIndex < length; bitmapIndex++) {
            serialized[bitmapIndex] = serializeImage(bitmapImages[bitmapIndex]);
        }
        return serialized;
    }

    public static Bitmap deserializeImage(byte[] byteImage) {
        return BitmapFactory.decodeByteArray(byteImage, 0, byteImage.length);
    }

    public static Bitmap[] deserializeImages(byte[][] byteImages) {
        int length = byteImages.length;
        Bitmap[] deserialized = new Bitmap[length];

        for (int bitmapIndex = 0; bitmapIndex < length; bitmapIndex++) {
            deserialized[bitmapIndex] = deserializeImage(byteImages[bitmapIndex]);
        }
        return deserialized;
    }
}
