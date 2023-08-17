package com.example.lab3_fx.convertor;

import java.awt.image.BufferedImage;

public class ImageConvertor {
    public static int[][] toPixelsArray(BufferedImage image) {
        var pixels = new int[image.getWidth()][image.getHeight()];
        for (int i = 0; i < image.getWidth(); i++)
            for (int j = 0; j < image.getHeight(); j++)
                pixels[i][j] = image.getRGB(i, j);
        return pixels;
    }
}
