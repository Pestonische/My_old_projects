package com.example.lab3_fx.convertor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PixelConvertor {
    public static double getBrightness(int rgb) {
        var color = new Color(rgb);
        return 0.2126 * color.getRed() + 0.7152 * color.getGreen() + 0.0722 * color.getBlue();
    }

    private static List<Double> getLocals(double[][] brightnesses, int x, int y, int r) {
        List<Double> locals = new ArrayList<>();
        for (int i = x - r; i <= x + r; i++) {
            for (int j = y - r; j <= y + r; j++) {
                if (i < 0 || j < 0 || i >= brightnesses.length || j >= brightnesses[i].length) {
                    continue;
                }
                locals.add(brightnesses[i][j]);
            }
        }
        return locals;
    }

    public static double getLocalBrightness(double[][] brightnesses, int x, int y, int r) {
        var locals = getLocals(brightnesses, x, y, r);
        return locals.size() == 0 ? 0 : locals.stream().reduce(Double::sum).get() / locals.size();
    }

    public static double getMaxLocalBrightness(double[][] brightnesses, int x, int y, int r) {
        var locals = getLocals(brightnesses, x, y, r);
        return locals.stream().reduce(Double::max).orElse(0.);
    }


    public static double getMinLocalBrightness(double[][] brightnesses, int x, int y, int r) {
        var locals = getLocals(brightnesses, x, y, r);
        return locals.stream().reduce(Double::min).orElse(0.);
    }
}
