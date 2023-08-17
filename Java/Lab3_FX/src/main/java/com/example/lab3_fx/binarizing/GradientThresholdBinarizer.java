package com.example.lab3_fx.binarizing;

import com.example.lab3_fx.convertor.ImageConvertor;
import com.example.lab3_fx.convertor.PixelConvertor;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class GradientThresholdBinarizer {

    public BufferedImage binarize(BufferedImage src) {
        var threshold = Threshold.calcGradient(ImageConvertor.toPixelsArray(src));
        var processed = new BufferedImage(src.getWidth(), src.getHeight(), TYPE_INT_RGB);
        for (int i = 0; i < src.getWidth(); i++)
            for (int j = 0; j < src.getHeight(); j++) {
                var b = PixelConvertor.getBrightness(src.getRGB(i, j));
                processed.setRGB(i, j, b <= threshold ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        return processed;
    }
}
