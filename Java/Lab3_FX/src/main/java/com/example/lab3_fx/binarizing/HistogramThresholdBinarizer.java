package com.example.lab3_fx.binarizing;

import com.example.lab3_fx.convertor.ImageConvertor;
import com.example.lab3_fx.convertor.PixelConvertor;
import lombok.AllArgsConstructor;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

@AllArgsConstructor
public class HistogramThresholdBinarizer {
    double eps;

    public BufferedImage binarize(BufferedImage src) {
        var threshold = Threshold.calcHistogram(ImageConvertor.toPixelsArray(src), eps);
        var processed = new BufferedImage(src.getWidth(), src.getHeight(), TYPE_INT_RGB);
        for (int i = 0; i < src.getWidth(); i++)
            for (int j = 0; j < src.getHeight(); j++) {
                var b = PixelConvertor.getBrightness(src.getRGB(i, j));
                processed.setRGB(i, j, b <= threshold ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        return processed;
    }
}
