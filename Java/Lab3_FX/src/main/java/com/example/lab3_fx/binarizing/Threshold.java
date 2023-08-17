package com.example.lab3_fx.binarizing;

import com.example.lab3_fx.convertor.PixelConvertor;

import java.util.ArrayList;
import java.util.List;

public class Threshold {

    public static final double ALPHA = 1. / 10.;

    public static double calcHistogram(int[][] pixels, double eps) {
        double prevT = 0;
        double t = 255. / 2;

        while (Math.abs(t - prevT) >= eps) {
            List<Double> group1 = new ArrayList<>();
            List<Double> group2 = new ArrayList<>();

            for (var row : pixels) {
                for (var pixel : row) {
                    var b = PixelConvertor.getBrightness(pixel);
                    if (b > t) {
                        group1.add(b);
                    } else {
                        group2.add(b);
                    }
                }
            }

            var mu1 = group1.size() == 0 ? 0 : group1.stream().reduce(Double::sum).orElse(0.) / group1.size();
            var mu2 = group2.size() == 0 ? 0 : group2.stream().reduce(Double::sum).orElse(0.) / group2.size();
            prevT = t;
            t = (mu1 + mu2) / 2.;
        }
        return t;
    }


    public static double calcGradient(int[][] pixels) {
        var brightnesses = new double[pixels.length][pixels[0].length];
        var gradients = new double[pixels.length][pixels[0].length];

        for (int i = 0; i < pixels.length; i++)
            for (int j = 0; j < pixels[i].length; j++)
                brightnesses[i][j] = PixelConvertor.getBrightness(pixels[i][j]);

        for (int i = 0; i < pixels.length - 1; i++)
            for (int j = 0; j < pixels[i].length - 1; j++)
                gradients[i][j] = Math.max(
                        brightnesses[i + 1][j] - brightnesses[i][j],
                        brightnesses[i][j + 1] - brightnesses[i][j]
                );

        var num = 0.00;
        for (int i = 0; i < pixels.length; i++)
            for (int j = 0; j < pixels[i].length; j++)
                num += brightnesses[i][j] * gradients[i][j];

        var den = 0.00;
        for (var row : gradients) {
            for (var g : row) {
                den += g;
            }
        }

        return num / den;
    }

    public static double[][] calcAdaptive(double[][] brightnesses, int startRadius) {
        var thresholds = new double[brightnesses.length][brightnesses[0].length];
        for (int i = 0; i < brightnesses.length; i++) {
            for (int j = 0; j < brightnesses[i].length; j++) {
                var radius = startRadius;
                while (true) {
                    var fMax = PixelConvertor.getMaxLocalBrightness(brightnesses, i, j, radius);
                    var fMin = PixelConvertor.getMinLocalBrightness(brightnesses, i, j, radius);
                    var local = PixelConvertor.getLocalBrightness(brightnesses, i, j, radius);
                    var deltaMax = Math.abs(fMax - local);
                    var deltaMin = Math.abs(fMin - local);

                    if (deltaMax > deltaMin) {
                        thresholds[i][j] = ALPHA * (2. / 3. * fMin + 1. / 3. * local);
                        break;
                    } else if (deltaMax < deltaMin) {
                        thresholds[i][j] = ALPHA * (1. / 3. * fMin + 2. / 3. * local);
                        break;
                    } else if (fMax == fMin) {
                        thresholds[i][j] = ALPHA * local;
                        break;
                    } else {
                        radius++;
                    }
                }
            }
        }
        return thresholds;
    }
}
