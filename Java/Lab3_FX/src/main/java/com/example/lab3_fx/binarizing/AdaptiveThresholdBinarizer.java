package com.example.lab3_fx.binarizing;

import com.example.lab3_fx.convertor.ImageConvertor;
import com.example.lab3_fx.convertor.PixelConvertor;
import lombok.AllArgsConstructor;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

@AllArgsConstructor
public class AdaptiveThresholdBinarizer {
    int radius;

    public BufferedImage binarize(BufferedImage src) {
        var pixels = ImageConvertor.toPixelsArray(src);
        var brightnesses = getBrightnesses(pixels);
        var locals = getLocalBrightnesses(brightnesses);
        System.out.println("locals");
        var thresholds = Threshold.calcAdaptive(brightnesses, radius);
        System.out.println("threshs");

        var processed = new BufferedImage(src.getWidth(), src.getHeight(), TYPE_INT_RGB);
        for (int i = 0; i < src.getWidth(); i++)
            for (int j = 0; j < src.getHeight(); j++) {
                var color = calcColorForPixel(locals, thresholds[i][j], brightnesses[i][j], i, j);
                processed.setRGB(i, j, color);
            }
        System.out.println("colors");
        return processed;
    }

    private int calcColorForPixel(double[][] locals, double t, double b, int x, int y) {
        var r = 1;
        boolean black = true;
        for (int i = x - r; i <= x + r; i++) {
            for (int j = y - r; j <= y + r; j++) {
                if (i < 0 || j < 0 || i >= locals.length || j >= locals[i].length || i == x && j == y) {
                    continue;
                }
                black &= Math.abs(locals[i][j] - b) > t;
            }
        }
        return black ? Color.BLACK.getRGB() : Color.WHITE.getRGB();
    }

    private double[][] getLocalBrightnesses(double[][] brightnesses) {
        var locals = new double[brightnesses.length][brightnesses[0].length];
        for (int i = 0; i < brightnesses.length; i++)
            for (int j = 0; j < brightnesses[i].length; j++)
                locals[i][j] = PixelConvertor.getLocalBrightness(brightnesses, i, j, radius);

        return locals;
    }

    private double[][] getBrightnesses(int[][] pixels) {
        var brightnesses = new double[pixels.length][pixels[0].length];
        for (int i = 0; i < pixels.length; i++)
            for (int j = 0; j < pixels[i].length; j++)
                brightnesses[i][j] = PixelConvertor.getBrightness(pixels[i][j]);

        return brightnesses;
    }
}
