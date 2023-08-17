package com.example.lab3_fx.binarizing;

import com.example.lab3_fx.convertor.ImageConvertor;
import com.example.lab3_fx.convertor.PixelConvertor;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class Segmentation {
    private final static int[][] HORIZONTAL_MASK = {{-1, -1, -1}, {2, 2, 2}, {-1, -1, -1}};
    private final static int[][] VERTICAL_MASK = {{-1, 2, -1}, {-1, 2, -1}, {-1, 2, -1}};
    private final static int[][] MINOR_DIAGONAL_MASK = {{-1, -1, 2}, {-1, 2, -1}, {2, -1, -1}};
    private final static int[][] MAJOR_DIAGONAL_MASK = {{2, -1, -1}, {-1, 2, -1}, {-1, -1, 2}};

    public BufferedImage binarize(BufferedImage src) {
        var pixels = ImageConvertor.toPixelsArray(src);
        var brightnesses = new double[pixels.length][pixels[0].length];
        var processed = new BufferedImage(src.getWidth(), src.getHeight(), TYPE_INT_RGB);

        for (int i = 0; i < pixels.length; i++)
            for (int j = 0; j < pixels[i].length; j++)
                brightnesses[i][j] = PixelConvertor.getBrightness(pixels[i][j]);

        for (int i = 0; i < src.getWidth(); i++)
            for (int j = 0; j < src.getHeight(); j++) {
                processed.setRGB(i, j, isOnLine(brightnesses, i, j) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
            }
        return processed;
    }

    private boolean isOnLine(double[][] b, int i, int j) {
        double r1 = calcR(b, i, j, HORIZONTAL_MASK);
        double r2 = calcR(b, i, j, VERTICAL_MASK);
        double r3 = calcR(b, i, j, MINOR_DIAGONAL_MASK);
        double r4 = calcR(b, i, j, MAJOR_DIAGONAL_MASK);

        return r3 > r4 || r4 > r3 ;
//        r1 > r2 && r1 > r3 && r1 > r4 ||
//                r2 > r1 && r2 > r3 && r2 > r4  ||
//                r3 > r1 && r3 > r2 && r3 > r4 ||
//                r4 > r1 && r4 > r2 && r4 > r3;
    }

    private double calcR(double[][] b, int x, int y, int[][] mask) {
        double sum = 0;
        int n = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (x + i < 0 || x + i >= b.length || y + j < 0 || y + j >= b[x + i].length){
                    continue;
                }
                sum += b[x+i][y+j] * mask[i + 1][j + 1];
                n++;
            }
        }
        return sum / n;
    }
}
